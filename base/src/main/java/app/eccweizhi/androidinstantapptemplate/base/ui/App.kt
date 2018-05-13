package app.eccweizhi.androidinstantapptemplate.base.ui

import android.app.Application
import app.eccweizhi.androidinstantapptemplate.base.BuildConfig
import timber.log.Timber


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // logging should always be the first thing to be setup
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
//            Timber.plant(CrashReportingTree())
        }
    }

}