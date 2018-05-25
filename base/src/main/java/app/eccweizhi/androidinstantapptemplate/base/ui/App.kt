package app.eccweizhi.androidinstantapptemplate.base.ui

import android.app.Application
import app.eccweizhi.androidinstantapptemplate.base.BuildConfig
import app.eccweizhi.androidinstantapptemplate.base.di.AppModule
import app.eccweizhi.androidinstantapptemplate.base.di.DaggerSingletonComponent
import app.eccweizhi.androidinstantapptemplate.base.di.LoggingModule
import app.eccweizhi.androidinstantapptemplate.base.di.SingletonComponent
import app.eccweizhi.androidinstantapptemplate.base.logger.CircularLogTree
import timber.log.Timber
import javax.inject.Inject


class App : Application() {
    lateinit var component: SingletonComponent
        private set

    @Inject
    protected lateinit var circularLogTree: CircularLogTree

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
            Timber.plant(Timber.DebugTree(), circularLogTree)
        } else {
            Timber.plant(circularLogTree)
        }
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}