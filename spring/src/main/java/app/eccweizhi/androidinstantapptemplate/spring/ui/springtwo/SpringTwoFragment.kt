package app.eccweizhi.androidinstantapptemplate.spring.ui.springtwo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragment
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.base.ui.FragmentListener
import app.eccweizhi.androidinstantapptemplate.base.ui.settings.SettingsFragment
import app.eccweizhi.androidinstantapptemplate.spring.R
import app.eccweizhi.androidinstantapptemplate.spring.di.DaggerSpringComponent
import app.eccweizhi.androidinstantapptemplate.spring.ui.SpringStuff
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject


class SpringTwoFragment : BaseFragment(),
        Mvp.View {
    @Inject
    protected lateinit var springStuff: SpringStuff

    private lateinit var presenter: Mvp.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerSpringComponent.builder()
                .screenComponent(screenComponent)
                .build()
                .inject(this)
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
        presenter = SpringTwoPresenter(this, networkService)
        return inflater.inflate(R.layout.fragment_spring_two, container, false)
    }

    companion object {
        const val FRAGMENT_TAG = "SpringTwoFragment"
        private const val ARG_PARAM_1 = "param1"

        @JvmStatic
        fun newInstance(param1: String): SpringTwoFragment {
            val frag = SpringTwoFragment()
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
        constructor(param1: String) : this(FRAGMENT_TAG, param1)

        override fun createFragment(): Fragment = newInstance(param1)
    }
}