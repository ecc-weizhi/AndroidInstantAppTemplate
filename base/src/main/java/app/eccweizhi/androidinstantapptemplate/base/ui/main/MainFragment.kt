package app.eccweizhi.androidinstantapptemplate.base.ui.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.eccweizhi.androidinstantapptemplate.base.R
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragment
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.base.ui.FragmentListener
import app.eccweizhi.androidinstantapptemplate.base.ui.ScreenIdentifier
import com.google.android.instantapps.InstantApps
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFragment : BaseFragment(),
        View.OnClickListener {
    var fragmentListener: FragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.featureOneButton.setOnClickListener(this)
        view.featureTwoButton.setOnClickListener(this)

        packageIdText.text = "package: $context?.applicationContext?.packageName"
        isInstantAppText.text = "isInstantApp: ${InstantApps.isInstantApp(context!!)}"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            fragmentListener = context as FragmentListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement FragmentListener")
        }
    }

    override fun onDetach() {
        fragmentListener = null
        super.onDetach()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.featureOneButton -> fragmentListener?.performAction(FRAGMENT_TAG,
                    FragmentListener.Action.Navigate,
                    ScreenIdentifier.URI_FEATURE_ONE)
            R.id.featureTwoButton -> fragmentListener?.performAction(FRAGMENT_TAG,
                    FragmentListener.Action.Navigate,
                    ScreenIdentifier.URI_FEATURE_TWO)
        }
    }

    companion object {
        const val FRAGMENT_TAG = "MainFragment"

        @JvmStatic
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    @Parcelize
    data class MainKey(val clazz: String) : BaseKey() {
        constructor() : this(FRAGMENT_TAG)

        override fun createFragment(): Fragment = newInstance()
    }
}