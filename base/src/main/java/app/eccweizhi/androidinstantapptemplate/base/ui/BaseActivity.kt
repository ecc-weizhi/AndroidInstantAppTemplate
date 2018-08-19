package app.eccweizhi.androidinstantapptemplate.base.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.eccweizhi.androidinstantapptemplate.base.di.screen.ContextModule
import app.eccweizhi.androidinstantapptemplate.base.di.screen.DaggerScreenComponent
import app.eccweizhi.androidinstantapptemplate.base.di.screen.GlideModule
import app.eccweizhi.androidinstantapptemplate.base.di.screen.ScreenComponent
import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService
import app.eccweizhi.androidinstantapptemplate.base.persistence.Store
import app.eccweizhi.onscreenlog.OnScreenLog
import com.bumptech.glide.RequestManager
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {
    @Inject
    protected lateinit var store: Store
    @Inject
    protected lateinit var onScreenLog: OnScreenLog
    @Inject
    protected lateinit var networkService: NetworkService
    @Inject
    protected lateinit var requestManager: RequestManager

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
}