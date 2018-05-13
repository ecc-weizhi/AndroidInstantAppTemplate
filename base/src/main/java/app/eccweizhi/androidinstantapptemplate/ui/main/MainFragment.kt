package app.eccweizhi.androidinstantapptemplate.ui.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.eccweizhi.androidinstantapptemplate.R
import app.eccweizhi.androidinstantapptemplate.ScreenIdentifier
import app.eccweizhi.androidinstantapptemplate.ui.BaseFragment
import app.eccweizhi.androidinstantapptemplate.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.ui.FragmentListener
import kotlinx.android.parcel.Parcelize
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
        constructor() : this(MainFragment.FRAGMENT_TAG)

        override fun createFragment(): Fragment = MainFragment.newInstance()
    }
}