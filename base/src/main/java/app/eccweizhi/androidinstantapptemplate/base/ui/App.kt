package app.eccweizhi.androidinstantapptemplate.base.ui

import android.app.Application
import app.eccweizhi.androidinstantapptemplate.base.BuildConfig
import app.eccweizhi.androidinstantapptemplate.base.di.AppModule
import app.eccweizhi.androidinstantapptemplate.base.di.DaggerSingletonComponent
import app.eccweizhi.androidinstantapptemplate.base.di.LoggingModule
import app.eccweizhi.androidinstantapptemplate.base.di.SingletonComponent
import timber.log.Timber


class App : Application() {
    lateinit var component: SingletonComponent
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        component = DaggerSingletonComponent
                .builder()
                .appModule(AppModule(this))
                .loggingModule(LoggingModule())
                .build()
        component.inject(this)

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