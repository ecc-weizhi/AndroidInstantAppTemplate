package app.eccweizhi.androidinstantapptemplate.spring.ui.springone

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragment
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.spring.R
import app.eccweizhi.androidinstantapptemplate.spring.di.DaggerSpringComponent
import app.eccweizhi.androidinstantapptemplate.spring.ui.SpringStuff
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject


class SpringOneFragment : BaseFragment(),
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
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        presenter = SpringOnePresenter(this, networkService)
        return inflater.inflate(R.layout.fragment_spring_one, container, false)
    }

    companion object {
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