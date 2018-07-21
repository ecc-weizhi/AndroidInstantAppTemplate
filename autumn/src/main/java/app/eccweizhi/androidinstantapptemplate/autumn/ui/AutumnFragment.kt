package app.eccweizhi.androidinstantapptemplate.autumn.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import app.eccweizhi.androidinstantapptemplate.autumn.R
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragment
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.base.ui.FragmentListener
import app.eccweizhi.androidinstantapptemplate.base.ui.settings.SettingsFragment
import kotlinx.android.parcel.Parcelize


class AutumnFragment : BaseFragment() {
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
        return inflater.inflate(R.layout.fragment_autumn, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
    data class Key(val clazz: String,
                   val param1: String) : BaseKey() {
        constructor(param1: String) : this(AutumnFragment.FRAGMENT_TAG, param1)

        override fun createFragment(): Fragment = AutumnFragment.newInstance(param1)
    }
}