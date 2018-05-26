package app.eccweizhi.androidinstantapptemplate.autumn.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.eccweizhi.androidinstantapptemplate.autumn.R
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragment
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.base.ui.FragmentListener
import kotlinx.android.parcel.Parcelize


class AutumnFragment : BaseFragment() {
    var fragmentListener: FragmentListener? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_autumn, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        const val FRAGMENT_TAG = "AutumnFragment"
        private const val ARG_PARAM_1 = "param1"

        @JvmStatic
        fun newInstance(param1: String): AutumnFragment {
            val frag = AutumnFragment()
            val args = Bundle().apply {
                putString(ARG_PARAM_1, param1)
            }
            frag.arguments = args
            return frag
        }
    }

    @Parcelize
    data class AutumnKey(val clazz: String,
                         val param1: String) : BaseKey() {
        constructor(param1: String) : this(AutumnFragment.FRAGMENT_TAG, param1)

        override fun createFragment(): Fragment = AutumnFragment.newInstance(param1)
    }
}