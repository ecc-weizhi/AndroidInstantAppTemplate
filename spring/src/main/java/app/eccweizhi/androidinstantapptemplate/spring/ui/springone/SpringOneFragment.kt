package app.eccweizhi.androidinstantapptemplate.spring.ui.springone

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
import app.eccweizhi.androidinstantapptemplate.spring.ui.springtwo.SpringTwoFragment
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_spring_one.*
import javax.inject.Inject


class SpringOneFragment : BaseFragment(),
        Mvp.View,
        View.OnClickListener {
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
        appLog.log(LOG_TAG, "onCreate")
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
        presenter = SpringOnePresenter(this, networkService)
        return inflater.inflate(R.layout.fragment_spring_one, container, false)
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        goToSpringTwoButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.goToSpringTwoButton -> fragmentListener?.performAction(FRAGMENT_TAG,
                    FragmentListener.Action.NavigateToScreen,
                    SpringTwoFragment.Key("foo"))
        }
    }

    companion object {
        private const val LOG_TAG = "SpringOneFragment"
        const val FRAGMENT_TAG = "SpringOneFragment"
        private const val ARG_PARAM_1 = "param1"

        @JvmStatic
        fun newInstance(param1: String): SpringOneFragment {
            val frag = SpringOneFragment()
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