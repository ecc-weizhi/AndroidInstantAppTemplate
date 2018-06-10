package app.eccweizhi.androidinstantapptemplate.base.di.screen

import android.content.Context
import app.eccweizhi.androidinstantapptemplate.base.di.application.ApplicationComponent
import app.eccweizhi.androidinstantapptemplate.base.logger.AppLog
import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragment
import com.bumptech.glide.RequestManager
import dagger.Component


@ScreenScope
@Component(modules = [ContextModule::class, GlideModule::class],
        dependencies = [ApplicationComponent::class])
interface ScreenComponent {
    fun inject(activity: BaseActivity)
    fun inject(fragment: BaseFragment)

    fun networkService(): NetworkService
    fun appLog(): AppLog
    fun requestManger(): RequestManager
    fun context(): Context
}