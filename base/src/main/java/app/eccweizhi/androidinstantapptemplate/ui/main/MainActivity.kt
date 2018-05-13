package app.eccweizhi.androidinstantapptemplate.ui.main

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import app.eccweizhi.androidinstantapptemplate.R
import app.eccweizhi.androidinstantapptemplate.ScreenIdentifier
import app.eccweizhi.androidinstantapptemplate.ui.FragmentListener
import app.eccweizhi.androidinstantapptemplate.ui.Key
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.*


class MainActivity : AppCompatActivity(),
        FragmentListener {

    private lateinit var backstackKeys: ArrayList<Key>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(activityToolbar)

        if (savedInstanceState == null) {
            Timber.i("onCreate no save instance")

            backstackKeys = intent.getParcelableArrayListExtra<Key>(EXTRA_KEY_BACKSTACK_KEYS)
                    ?: arrayListOf()

            if (backstackKeys.isEmpty()) {
                backstackKeys.add(MainFragment.MainKey())
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
            ScreenIdentifier.URI_FEATURE_ONE -> {
                val newIntent = Intent(Intent.ACTION_VIEW,
                        Uri.parse(ScreenIdentifier.URI_FEATURE_ONE)).apply {
                    addCategory(Intent.CATEGORY_BROWSABLE)
                }

                startActivity(newIntent)
            }
            ScreenIdentifier.URI_FEATURE_TWO -> {
                val newIntent = Intent(Intent.ACTION_VIEW,
                        Uri.parse(ScreenIdentifier.URI_FEATURE_TWO)).apply {
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