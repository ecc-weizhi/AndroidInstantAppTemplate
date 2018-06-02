package app.eccweizhi.androidinstantapptemplate.base.di

import android.content.Context
import app.eccweizhi.androidinstantapptemplate.base.logger.AppLog
import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService
import app.eccweizhi.androidinstantapptemplate.base.ui.App
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    (LoggingModule::class),
    (AppModule::class)])
interface SingletonComponent {
    fun inject(app: App)

    fun context(): Context
    fun networkService(): NetworkService
    fun appLog(): AppLog
}
