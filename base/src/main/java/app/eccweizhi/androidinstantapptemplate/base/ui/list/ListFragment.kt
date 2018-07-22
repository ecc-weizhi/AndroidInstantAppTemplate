package app.eccweizhi.androidinstantapptemplate.base.ui.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.eccweizhi.androidinstantapptemplate.base.R
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragmentWithDefaultActionBar
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.base.ui.FeatureUriString
import app.eccweizhi.androidinstantapptemplate.base.ui.FragmentListener
import app.eccweizhi.androidinstantapptemplate.base.ui.list.groupie.AdapterWrapper
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : BaseFragmentWithDefaultActionBar(),
        Mvp.View,
        AdapterWrapper.Listener {
    private lateinit var adapterWrapper: AdapterWrapper
    private lateinit var presenter: Mvp.Presenter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        presenter = ListPresenter(this,
                networkService)
        adapterWrapper = AdapterWrapper(context!!,
                requestManager)
        return inflater.inflate(R.layout.fragment_list,
                container,
                false)
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        super.onViewCreated(view,
                savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapterWrapper.adapter
        paramEditText.enableAutoDismissKeyboard(true)
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
        presenter.onSpringClick(paramEditText.text.toString())
    }

    override fun onSummerClick() {
        presenter.onSummerClick(paramEditText.text.toString())
    }

    override fun onAutumnClick() {
        presenter.onAutumnClick(paramEditText.text.toString())
    }

    override fun onWinterClick() {
        presenter.onWinterClick(paramEditText.text.toString())
    }

    override fun getTitle(): CharSequence? = getString(R.string.title_list)

    override fun getSubtitle(): CharSequence? = null

    override fun goToSpring(param: String) {
        fragmentListener?.performAction(FragmentListener.Action.NavigateToFeature,
                FeatureUriString.newSpringIntent(param))
    }

    override fun goToSummer(param: String) {
        fragmentListener?.performAction(FragmentListener.Action.NavigateToFeature,
                FeatureUriString.newSummerIntent(param))
    }

    override fun goToAutumn(param: String) {
        fragmentListener?.performAction(FragmentListener.Action.NavigateToFeature,
                FeatureUriString.newAutumnIntent(param))
    }

    override fun goToWinter(param: String) {
        fragmentListener?.performAction(FragmentListener.Action.NavigateToFeature,
                FeatureUriString.newWinterIntent(param))
    }

    companion object {
        private const val LOG_TAG = "ListFragment"
        const val FRAGMENT_TAG = "ListFragment"

        @JvmStatic
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }

    @Parcelize
    data class Key(val clazz: String) : BaseKey() {
        constructor() : this(FRAGMENT_TAG)

        override fun createFragment(): Fragment = newInstance()
    }
}