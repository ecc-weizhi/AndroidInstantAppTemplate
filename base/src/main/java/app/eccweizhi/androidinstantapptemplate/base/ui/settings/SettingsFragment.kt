package app.eccweizhi.androidinstantapptemplate.base.ui.settings

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.eccweizhi.androidinstantapptemplate.base.R
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragment
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import com.google.android.instantapps.InstantApps
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : BaseFragment(),
        Mvp.View {
    private lateinit var presenter: Mvp.Presenter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        presenter = SettingsPresenter(this, store)
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity()
        val packageName = activity.packageName
        val packageManager = activity.packageManager
        val versionCode = packageManager.getPackageInfo(packageName, 0).versionCode
        versionCodeText.text = versionCode.toString()
        isInstantAppText.text = InstantApps.isInstantApp(activity).toString()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onStop() {
        presenter.onStop(showLogSwitch.isChecked)
        super.onStop()
    }

    override fun showShowLog(showLog: Boolean) {
        showLogSwitch.isChecked = showLog
    }

    companion object {
        const val FRAGMENT_TAG = "SettingsFragment"

        @JvmStatic
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    @Parcelize
    data class Key(val clazz: String) : BaseKey() {
        constructor() : this(FRAGMENT_TAG)

        override fun createFragment(): Fragment = newInstance()
    }
}