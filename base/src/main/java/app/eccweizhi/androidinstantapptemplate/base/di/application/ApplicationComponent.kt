package app.eccweizhi.androidinstantapptemplate.base.di.application

import android.app.Application
import app.eccweizhi.androidinstantapptemplate.base.logger.AppLog
import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService
import app.eccweizhi.androidinstantapptemplate.base.persistence.SettingsPref
import app.eccweizhi.androidinstantapptemplate.base.persistence.Store
import app.eccweizhi.androidinstantapptemplate.base.ui.App
import dagger.Component


@ApplicationScope
@Component(modules = [
    (LoggingModule::class),
    (AppModule::class)])
interface ApplicationComponent {
    fun inject(app: App)

    fun application(): Application
    fun networkService(): NetworkService
    fun appLog(): AppLog
    fun store(): Store
    fun settingPref(): SettingsPref
}
