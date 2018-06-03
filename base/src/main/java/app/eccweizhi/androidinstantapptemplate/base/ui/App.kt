package app.eccweizhi.androidinstantapptemplate.base.ui

import android.app.Application
import app.eccweizhi.androidinstantapptemplate.base.BuildConfig
import app.eccweizhi.androidinstantapptemplate.base.di.application.AppModule
import app.eccweizhi.androidinstantapptemplate.base.di.application.ApplicationComponent
import app.eccweizhi.androidinstantapptemplate.base.di.application.DaggerApplicationComponent
import app.eccweizhi.androidinstantapptemplate.base.di.application.LoggingModule
import timber.log.Timber


class App : Application() {
    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        applicationComponent = DaggerApplicationComponent.builder()
                .appModule(AppModule(this))
                .loggingModule(LoggingModule())
                .build()
        applicationComponent.inject(this)

        // logging should always be the first thing to be setup
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}