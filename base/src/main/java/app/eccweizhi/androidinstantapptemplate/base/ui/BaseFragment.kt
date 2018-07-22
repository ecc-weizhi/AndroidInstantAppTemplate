package app.eccweizhi.androidinstantapptemplate.base.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import app.eccweizhi.androidinstantapptemplate.base.di.screen.ContextModule
import app.eccweizhi.androidinstantapptemplate.base.di.screen.DaggerScreenComponent
import app.eccweizhi.androidinstantapptemplate.base.di.screen.GlideModule
import app.eccweizhi.androidinstantapptemplate.base.di.screen.ScreenComponent
import app.eccweizhi.androidinstantapptemplate.base.logger.AppLog
import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService
import app.eccweizhi.androidinstantapptemplate.base.persistence.Store
import com.bumptech.glide.RequestManager
import javax.inject.Inject


abstract class BaseFragment : Fragment() {
    @Inject
    protected lateinit var store: Store
    @Inject
    protected lateinit var appLog: AppLog
    @Inject
    protected lateinit var networkService: NetworkService
    @Inject
    protected lateinit var requestManager: RequestManager

    protected var fragmentListener: FragmentListener? = null
    protected val screenComponent: ScreenComponent by lazy {
        DaggerScreenComponent.builder()
                .applicationComponent(App.INSTANCE.applicationComponent)
                .contextModule(ContextModule(this))
                .glideModule(GlideModule(this))
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        screenComponent.inject(this)
        super.onCreate(savedInstanceState)
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
        fragmentListener?.setScreenName(getTitle(),
                getSubtitle())
    }

    abstract fun getTitle(): CharSequence?

    abstract fun getSubtitle(): CharSequence?

    fun <K : Key> getKey(): K = arguments!!.getParcelable(KEY_TAG) as K

    companion object {
        const val KEY_TAG = "KEY"
    }
}