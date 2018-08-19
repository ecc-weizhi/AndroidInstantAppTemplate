package app.eccweizhi.androidinstantapptemplate.base.di.screen

import android.content.Context
import app.eccweizhi.androidinstantapptemplate.base.di.application.ApplicationComponent
import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService
import app.eccweizhi.androidinstantapptemplate.base.persistence.SettingsPref
import app.eccweizhi.androidinstantapptemplate.base.persistence.Store
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseFragment
import app.eccweizhi.onscreenlog.OnScreenLog
import com.bumptech.glide.RequestManager
import dagger.Component


@ScreenScope
@Component(modules = [ContextModule::class, GlideModule::class],
        dependencies = [ApplicationComponent::class])
interface ScreenComponent {
    fun inject(activity: BaseActivity)
    fun inject(fragment: BaseFragment)

    fun networkService(): NetworkService
    fun onScreenLog(): OnScreenLog
    fun requestManger(): RequestManager
    fun context(): Context
    fun store(): Store
    fun settingPref(): SettingsPref
}