package app.eccweizhi.androidinstantapptemplate.winter.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragmentWithDefaultActionBar
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.winter.R
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_winter.*


class WinterFragment : BaseFragmentWithDefaultActionBar() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_winter,
                container,
                false)
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        val param = arguments?.getString(ARG_PARAM_1)
        paramText.text = getString(R.string.param_text,
                param)
    }

    override fun getTitle(): CharSequence? = getString(R.string.title_winter)

    override fun getSubtitle(): CharSequence? = null

    companion object {
        const val FRAGMENT_TAG = "WinterFragment"
        private const val ARG_PARAM_1 = "param1"

        @JvmStatic
        fun newInstance(param1: String?): WinterFragment {
            val frag = WinterFragment()
            val args = Bundle().apply {
                putString(ARG_PARAM_1, param1)
            }
            frag.arguments = args
            return frag
        }
    }

    @Parcelize
    data class Key(val clazz: String,
                   val param1: String?) : BaseKey() {
        constructor(param1: String?) : this(WinterFragment.FRAGMENT_TAG, param1)

        override fun createFragment(): Fragment = WinterFragment.newInstance(param1)
    }
}