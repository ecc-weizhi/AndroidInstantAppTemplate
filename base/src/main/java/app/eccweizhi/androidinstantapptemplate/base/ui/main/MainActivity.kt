package app.eccweizhi.androidinstantapptemplate.base.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import app.eccweizhi.androidinstantapptemplate.base.R
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.FragmentListener
import app.eccweizhi.androidinstantapptemplate.base.ui.Key
import app.eccweizhi.androidinstantapptemplate.base.ui.list.ListFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.*


class MainActivity : BaseActivity(),
        Mvp.View,
        FragmentListener {

    private lateinit var presenter: Mvp.Presenter
    private lateinit var backstackKeys: ArrayList<Key>
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("MainActivity onCreate taskId: %d", taskId)

        setContentView(R.layout.activity_main)
        setSupportActionBar(activityToolbar)
        setupLogView()

        presenter = MainPresenter(this,
                networkService)

        // form backstack
        if (savedInstanceState == null) {
            backstackKeys = intent.getParcelableArrayListExtra<Key>(EXTRA_KEY_BACKSTACK_KEYS)
                    ?: arrayListOf()

            if (backstackKeys.isEmpty()) {
                backstackKeys.add(ListFragment.Key())
            }
        } else {
            backstackKeys = savedInstanceState.getParcelableArrayList<Key>(EXTRA_KEY_BACKSTACK_KEYS)
                    ?: arrayListOf()
        }
        Timber.d("onCreate, taskId: $taskId, backstack: $backstackKeys")
        goToFragment(backstackKeys.last())
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(EXTRA_KEY_BACKSTACK_KEYS, backstackKeys)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        val newIntentBackstackKeys = intent.getParcelableArrayListExtra<Key>(
                EXTRA_KEY_BACKSTACK_KEYS)
        backstackKeys.addAll(newIntentBackstackKeys)

        Timber.d("onNewIntent: $backstackKeys")

        goToFragment(backstackKeys.last())
    }

    override fun performAction(action: FragmentListener.Action,
                               vararg data: Any) {
        when (action) {
            FragmentListener.Action.NavigateToFeature -> {
                val featureIntent = data[0] as Intent
                startActivity(featureIntent)
            }
            FragmentListener.Action.NavigateToScreen -> {
                val fragmentKey = data[0] as Key
                backstackKeys.add(fragmentKey)
                goToFragment(backstackKeys.last())
            }
        }
    }

    override fun setScreenName(title: CharSequence?,
                               subtitle: CharSequence?) {
        supportActionBar?.title = title
        supportActionBar?.subtitle = subtitle
    }

    override fun onBackPressed() {
        if (backstackKeys.size == 1) {
            super.onBackPressed()
        } else {
            backstackKeys.removeAt(backstackKeys.lastIndex)
            goToFragment(backstackKeys.last())
        }
    }

    private fun setupLogView() {
        logRecyclerView.layoutManager = LinearLayoutManager(this)
        logRecyclerView.adapter = onScreenLog.adapter

        val showLogDisposable = store.readSettingsShowLog()
                .subscribe {
                    logRecyclerView.visibility = if (it) View.VISIBLE else View.GONE
                }
        compositeDisposable.add(showLogDisposable)
    }

    private fun goToFragment(key: Key) {
        Timber.d("goToFragment $key")
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, key.newFragment(), key.fragmentTag)
                .commit()
    }

    companion object {
        /**
         * Intent extra key for [ArrayList] of [Key]. This [ArrayList] is our fragment backstack
         */
        const val EXTRA_KEY_BACKSTACK_KEYS = "BACKSTACK_KEYS"

        fun startWith(activity: Activity,
                      vararg keys: Key) {
            val intent = Intent(activity,
                    MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        or Intent.FLAG_ACTIVITY_SINGLE_TOP
                        or Intent.FLAG_ACTIVITY_NEW_TASK)

                val keyStack = ArrayList<Parcelable>().apply {
                    addAll(keys)
                }

                putExtra(EXTRA_KEY_BACKSTACK_KEYS,
                        keyStack)
            }
            activity.startActivity(intent)
            activity.finish()
        }
    }
}