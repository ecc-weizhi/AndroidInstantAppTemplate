package app.eccweizhi.androidinstantapptemplate.base.ui.list

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.eccweizhi.androidinstantapptemplate.base.R
import app.eccweizhi.androidinstantapptemplate.base.ui.App
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragment
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.base.ui.FragmentListener
import app.eccweizhi.androidinstantapptemplate.base.ui.list.groupie.AdapterWrapper
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


class ListFragment : BaseFragment(),
        Mvp.View,
        AdapterWrapper.Listener {
    @Inject
    lateinit var presenter: Mvp.Presenter
    @Inject
    lateinit var adapterWrapper: AdapterWrapper
    var fragmentListener: FragmentListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        getListFragmentComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapterWrapper.adapter
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

    override fun onStart() {
        super.onStart()
        adapterWrapper.listener = this
    }

    override fun onStop() {
        adapterWrapper.listener = this
        super.onStop()
    }

    override fun onSpringClick() {
        presenter.onSpringClick()
    }

    override fun onSummerClick() {
        presenter.onSummerClick()
    }

    override fun onAutumnClick() {
        presenter.onAutumnClick()
    }

    override fun onWinterClick() {
        presenter.onWinterClick()
    }

    override fun navigateTo(screenIdentifier: String) {
        fragmentListener?.performAction(FRAGMENT_TAG,
                FragmentListener.Action.Navigate,
                screenIdentifier)
    }

    private fun getListFragmentComponent(): ListFragmentComponent {
        val componentKey = ListFragmentComponent::class.java.canonicalName
        val cached = App.INSTANCE.componentMap[componentKey]

        val component: ListFragmentComponent = if (cached == null) {
            val newComponent = DaggerListFragmentComponent.builder()
                    .listFragmentModule(ListFragmentModule(this))
                    .build()
            App.INSTANCE.componentMap[componentKey] = newComponent
            newComponent
        } else {
            cached as ListFragmentComponent
        }
        return component
    }

    companion object {
        const val FRAGMENT_TAG = "ListFragment"

        @JvmStatic
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }

    @Parcelize
    data class MainKey(val clazz: String) : BaseKey() {
        constructor() : this(FRAGMENT_TAG)

        override fun createFragment(): Fragment = newInstance()
    }
}