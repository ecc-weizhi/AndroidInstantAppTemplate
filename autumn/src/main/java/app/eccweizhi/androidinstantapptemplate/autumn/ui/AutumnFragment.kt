package app.eccweizhi.androidinstantapptemplate.autumn.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.eccweizhi.androidinstantapptemplate.autumn.R
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragmentWithDefaultActionBar
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_autumn.*


class AutumnFragment : BaseFragmentWithDefaultActionBar() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_autumn,
                container,
                false)
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        val param = arguments?.getString(ARG_PARAM_1)
        paramText.text = getString(R.string.param_text,
                param)
    }

    override fun getTitle(): CharSequence? = getString(R.string.title_autumn)

    override fun getSubtitle(): CharSequence? = null

    companion object {
        const val FRAGMENT_TAG = "AutumnFragment"
        private const val ARG_PARAM_1 = "param1"

        @JvmStatic
        fun newInstance(param1: String): AutumnFragment {
            val frag = AutumnFragment()
            val args = Bundle().apply {
                putString(ARG_PARAM_1,
                        param1)
            }
            frag.arguments = args
            return frag
        }
    }

    @Parcelize
    data class Key(val clazz: String,
                   val param1: String) : BaseKey() {
        constructor(param1: String) : this(AutumnFragment.FRAGMENT_TAG,
                param1)

        override fun createFragment(): Fragment = AutumnFragment.newInstance(param1)
    }
}