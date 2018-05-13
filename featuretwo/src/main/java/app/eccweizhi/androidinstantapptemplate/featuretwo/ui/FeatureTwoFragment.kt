package app.eccweizhi.androidinstantapptemplate.featuretwo.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.eccweizhi.androidinstantapptemplate.featuretwo.R
import app.eccweizhi.androidinstantapptemplate.ui.BaseFragment
import app.eccweizhi.androidinstantapptemplate.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.ui.FragmentListener
import kotlinx.android.parcel.Parcelize


class FeatureTwoFragment : BaseFragment() {
    var fragmentListener: FragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feature_two, container, false)
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

    companion object {
        const val FRAGMENT_TAG = "FeatureTwoFragment"
        private const val ARG_PARAM_1 = "param1"

        @JvmStatic
        fun newInstance(param1: String): FeatureTwoFragment {
            val frag = FeatureTwoFragment()
            val args = Bundle().apply {
                putString(ARG_PARAM_1, param1)
            }
            frag.arguments = args
            return frag
        }
    }

    @Parcelize
    data class FeatureTwoKey(val clazz: String,
                             val param1: String) : BaseKey() {
        constructor(param1: String) : this(FeatureTwoFragment.FRAGMENT_TAG, param1)

        override fun createFragment(): Fragment = FeatureTwoFragment.newInstance(param1)
    }
}