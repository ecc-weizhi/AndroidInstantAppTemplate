package app.eccweizhi.androidinstantapptemplate.base.ui.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import app.eccweizhi.androidinstantapptemplate.base.R
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragment
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseKey
import app.eccweizhi.androidinstantapptemplate.base.ui.FragmentListener
import app.eccweizhi.androidinstantapptemplate.base.ui.list.groupie.AdapterWrapper
import app.eccweizhi.androidinstantapptemplate.base.ui.settings.SettingsFragment
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_main.*


class ListFragment : BaseFragment(),
        Mvp.View,
        AdapterWrapper.Listener {
    private lateinit var adapterWrapper: AdapterWrapper
    private lateinit var presenter: Mvp.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu,
                                     inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list, menu)
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
        presenter = ListPresenter(this, networkService)
        adapterWrapper = AdapterWrapper(context!!, requestManager)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapterWrapper.adapter
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

    override fun goToFeature(featureUri: String) {
        appLog.log(LOG_TAG, "goToFeature $featureUri")
        fragmentListener?.performAction(FRAGMENT_TAG,
                FragmentListener.Action.NavigateToFeature,
                featureUri)
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