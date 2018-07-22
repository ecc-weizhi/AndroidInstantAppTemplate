package app.eccweizhi.androidinstantapptemplate.spring.ui.springtwo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragmentWithDefaultActionBar
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.spring.R
import app.eccweizhi.androidinstantapptemplate.spring.di.DaggerSpringComponent
import app.eccweizhi.androidinstantapptemplate.spring.ui.SpringStuff
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject


class SpringTwoFragment : BaseFragmentWithDefaultActionBar(),
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
        presenter = SpringTwoPresenter(this, networkService)
        return inflater.inflate(R.layout.fragment_spring_two, container, false)
    }

    override fun getTitle(): CharSequence? = getString(R.string.title_spring_two)

    override fun getSubtitle(): CharSequence? = null

    companion object {
        const val FRAGMENT_TAG = "SpringTwoFragment"

        @JvmStatic
        fun newInstance(): SpringTwoFragment = SpringTwoFragment()
    }

    @Parcelize
    data class Key(val clazz: String) : BaseKey() {
        constructor() : this(FRAGMENT_TAG)

        override fun createFragment(): Fragment = newInstance()
    }
}