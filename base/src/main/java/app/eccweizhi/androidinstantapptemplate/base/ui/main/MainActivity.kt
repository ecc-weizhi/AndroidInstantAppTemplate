package app.eccweizhi.androidinstantapptemplate.base.ui.main

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import app.eccweizhi.androidinstantapptemplate.base.R
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.FragmentListener
import app.eccweizhi.androidinstantapptemplate.base.ui.Key
import app.eccweizhi.androidinstantapptemplate.base.ui.ScreenIdentifier
import app.eccweizhi.androidinstantapptemplate.base.ui.list.ListFragment
import app.eccweizhi.androidinstantapptemplate.base.ui.settings.SettingsFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BaseActivity(),
        Mvp.View,
        FragmentListener {

    private lateinit var presenter: Mvp.Presenter
    private lateinit var backstackKeys: ArrayList<Key>
    private val logSection = Section()
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this, networkService)

        setupLogView()

        setSupportActionBar(activityToolbar)

        if (savedInstanceState == null) {
            backstackKeys = intent.getParcelableArrayListExtra<Key>(EXTRA_KEY_BACKSTACK_KEYS)
                    ?: arrayListOf()

            if (backstackKeys.isEmpty()) {
                backstackKeys.add(ListFragment.Key())
            }

            appLog.log(LOG_TAG, "onCreate. hasSaveState: false. $backstackKeys")
            goToFragment(backstackKeys.last())
        } else {
            backstackKeys = savedInstanceState.getParcelableArrayList<Key>(EXTRA_KEY_BACKSTACK_KEYS)
                    ?: arrayListOf()

            appLog.log(LOG_TAG, "onCreate. hasSaveState: true. $backstackKeys")
            goToFragment(backstackKeys.last())
        }
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

        val newIntentBackstackKeys = intent.getParcelableArrayListExtra<Key>(EXTRA_KEY_BACKSTACK_KEYS)
        backstackKeys.addAll(newIntentBackstackKeys)

        appLog.log(LOG_TAG, "onNewIntent: $backstackKeys")

        goToFragment(backstackKeys.last())
    }

    override fun performAction(fragmentTag: String,
                               action: FragmentListener.Action,
                               vararg data: Any) {
        when (action) {
            FragmentListener.Action.Navigate -> performNavigate(data[0] as String)
        }
    }

    override fun onBackPressed() {
        if (backstackKeys.size == 1) {
            super.onBackPressed()
        } else {
            backstackKeys.removeAt(backstackKeys.lastIndex)
            goToFragment(backstackKeys.last())
        }
    }

    private fun performNavigate(identifier: String) {
        when (identifier) {
            ScreenIdentifier.URI_FEATURE_SPRING -> {
                val newIntent = Intent(Intent.ACTION_VIEW,
                        Uri.parse(ScreenIdentifier.URI_FEATURE_SPRING)).apply {
                    addCategory(Intent.CATEGORY_BROWSABLE)
                }

                startActivity(newIntent)
            }
            ScreenIdentifier.URI_FEATURE_SUMMER -> {
                val newIntent = Intent(Intent.ACTION_VIEW,
                        Uri.parse(ScreenIdentifier.URI_FEATURE_SUMMER)).apply {
                    addCategory(Intent.CATEGORY_BROWSABLE)
                }

                startActivity(newIntent)
            }
            ScreenIdentifier.URI_FEATURE_AUTUMN -> {
                val newIntent = Intent(Intent.ACTION_VIEW,
                        Uri.parse(ScreenIdentifier.URI_FEATURE_AUTUMN)).apply {
                    addCategory(Intent.CATEGORY_BROWSABLE)
                }

                startActivity(newIntent)
            }
            ScreenIdentifier.URI_FEATURE_WINTER -> {
                val newIntent = Intent(Intent.ACTION_VIEW,
                        Uri.parse(ScreenIdentifier.URI_FEATURE_WINTER)).apply {
                    addCategory(Intent.CATEGORY_BROWSABLE)
                }

                startActivity(newIntent)
            }
            ScreenIdentifier.SETTINGS -> {
                startWith(this, SettingsFragment.Key())
            }
            else -> {
                throw NotImplementedError()
            }
        }
    }

    private fun setupLogView() {
        logRecyclerView.layoutManager = LinearLayoutManager(this)
        val groupAdapter = GroupAdapter<ViewHolder>()
        groupAdapter.add(logSection)
        logRecyclerView.adapter = groupAdapter

        val logDisposable = appLog.subject
                .map { it.map { LogItem(it.id, it.tag, it.content) } }
                .subscribe {
                    logSection.update(it)
                    logRecyclerView.smoothScrollToPosition(logRecyclerView.adapter.itemCount)
                }
        compositeDisposable.add(logDisposable)

        val showLogDisposable = store.readSettingsShowLog()
                .subscribe {
                    logRecyclerView.visibility = if (it) View.VISIBLE else View.GONE
                }
        compositeDisposable.add(showLogDisposable)
    }

    private fun goToFragment(key: Key) {
        appLog.log(LOG_TAG, "goTo $key")
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, key.newFragment(), key.fragmentTag)
                .commit()
    }

    companion object {
        /**
         * Intent extra key for [ArrayList] of [Key]. This [ArrayList] is our fragment backstack
         */
        const val EXTRA_KEY_BACKSTACK_KEYS = "BACKSTACK_KEYS"
        const val LOG_TAG = "MainActivity"

        fun startWith(activity: Activity, vararg keys: Key) {
            val intent = Intent(activity, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)

                val keyStack = ArrayList<Parcelable>().apply {
                    addAll(keys)
                }

                putExtra(EXTRA_KEY_BACKSTACK_KEYS, keyStack)
            }
            activity.startActivity(intent)
        }
    }
}