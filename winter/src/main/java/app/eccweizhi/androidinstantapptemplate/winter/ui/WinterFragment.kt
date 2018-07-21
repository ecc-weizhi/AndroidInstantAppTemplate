package app.eccweizhi.androidinstantapptemplate.winter.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragment
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.base.ui.FragmentListener
import app.eccweizhi.androidinstantapptemplate.base.ui.settings.SettingsFragment
import app.eccweizhi.androidinstantapptemplate.winter.R
import kotlinx.android.parcel.Parcelize


class WinterFragment : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu,
                                     inflater: MenuInflater) {
        inflater.inflate(app.eccweizhi.androidinstantapptemplate.base.R.menu.menu_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                fragmentListener?.performAction(FRAGMENT_TAG,
                        FragmentListener.Action.NavigateToScreen,
                        SettingsFragment.Key())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_winter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val FRAGMENT_TAG = "WinterFragment"
        private const val ARG_PARAM_1 = "param1"

        @JvmStatic
        fun newInstance(param1: String): WinterFragment {
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
                   val param1: String) : BaseKey() {
        constructor(param1: String) : this(WinterFragment.FRAGMENT_TAG, param1)

        override fun createFragment(): Fragment = WinterFragment.newInstance(param1)
    }
}