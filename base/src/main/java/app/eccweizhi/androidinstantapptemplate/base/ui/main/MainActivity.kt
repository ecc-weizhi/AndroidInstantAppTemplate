package app.eccweizhi.androidinstantapptemplate.base.ui.main

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import app.eccweizhi.androidinstantapptemplate.base.R
import app.eccweizhi.androidinstantapptemplate.base.ui.App
import app.eccweizhi.androidinstantapptemplate.base.ui.FragmentListener
import app.eccweizhi.androidinstantapptemplate.base.ui.Key
import app.eccweizhi.androidinstantapptemplate.base.ui.ScreenIdentifier
import app.eccweizhi.androidinstantapptemplate.base.ui.list.ListFragment
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(),
        Mvp.View,
        FragmentListener {

    @Inject
    protected lateinit var presenter: Mvp.Presenter

    private lateinit var backstackKeys: ArrayList<Key>

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMainActivityComponent.builder()
                .singletonComponent(App.INSTANCE.component)
                .mainActivityModule(MainActivityModule(this))
                .build()
                .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(activityToolbar)

        if (savedInstanceState == null) {
            Timber.i("onCreate no save instance")

            backstackKeys = intent.getParcelableArrayListExtra<Key>(EXTRA_KEY_BACKSTACK_KEYS)
                    ?: arrayListOf()

            if (backstackKeys.isEmpty()) {
                backstackKeys.add(ListFragment.MainKey())
            }

            goToFragment(backstackKeys.last())
        } else {
            backstackKeys = savedInstanceState.getParcelableArrayList<Key>(EXTRA_KEY_BACKSTACK_KEYS)
                    ?: arrayListOf()
            goToFragment(backstackKeys.last())

            Timber.i("onCreate has save instance")
        }

        Timber.i("oncreate backstack: %s", backstackKeys)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(EXTRA_KEY_BACKSTACK_KEYS, backstackKeys)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        val newIntentBackstackKeys = intent.getParcelableArrayListExtra<Key>(EXTRA_KEY_BACKSTACK_KEYS)
        backstackKeys.addAll(newIntentBackstackKeys)

        Toast.makeText(this, "onNewIntent: ${backstackKeys}", Toast.LENGTH_LONG).show()
        Timber.i("onNewIntent: %s", backstackKeys)

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
        }
    }

    private fun goToFragment(key: Key) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, key.newFragment(), key.fragmentTag)
                .commit()
    }

    companion object {
        /**
         * Intent extra key for [ArrayList] of [Key]. This [ArrayList] is our fragment backstack
         */
        const val EXTRA_KEY_BACKSTACK_KEYS = "BACKSTACK_KEYS"

        fun startWith(activity: Activity, vararg keys: Key) {
            val intent = Intent(activity, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)

                val keyStack = ArrayList<Parcelable>().apply {
                    addAll(keys)
                }

                putExtra(EXTRA_KEY_BACKSTACK_KEYS, keyStack)
            }
            activity.startActivity(intent)
            activity.finish()
        }
    }
}