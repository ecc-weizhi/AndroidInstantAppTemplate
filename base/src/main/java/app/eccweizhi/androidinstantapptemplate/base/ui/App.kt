package app.eccweizhi.androidinstantapptemplate.base.ui

import android.app.Application
import app.eccweizhi.androidinstantapptemplate.base.di.application.AppModule
import app.eccweizhi.androidinstantapptemplate.base.di.application.ApplicationComponent
import app.eccweizhi.androidinstantapptemplate.base.di.application.DaggerApplicationComponent
import app.eccweizhi.androidinstantapptemplate.base.di.application.LoggingModule
import app.eccweizhi.onscreenlog.OnScreenLog
import app.eccweizhi.onscreenlog.timber.OnScreenLoggingTree
import timber.log.Timber
import javax.inject.Inject


class App : Application() {
    lateinit var applicationComponent: ApplicationComponent
        private set
    @Inject
    protected lateinit var onScreenLog: OnScreenLog

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        applicationComponent = DaggerApplicationComponent.builder()
                .appModule(AppModule(this))
                .loggingModule(LoggingModule())
                .build()
        applicationComponent.inject(this)

        // logging should always be the first thing to be setup
        Timber.plant(OnScreenLoggingTree(onScreenLog))
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}