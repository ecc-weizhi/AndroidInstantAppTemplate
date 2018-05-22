package app.eccweizhi.androidinstantapptemplate.base.ui

import android.app.Activity
import android.app.Application
import app.eccweizhi.androidinstantapptemplate.base.BuildConfig
import app.eccweizhi.androidinstantapptemplate.base.di.DaggerSingletonComponent
import app.eccweizhi.androidinstantapptemplate.base.logger.CircularLogTree
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject


class App : Application(), HasActivityInjector {
    @Inject
    internal lateinit var circularLogTree: CircularLogTree
    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()

        DaggerSingletonComponent
                .builder()
                .application(this)
                .build()
                .inject(this)

        // logging should always be the first thing to be setup
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree(), circularLogTree)
        } else {
            Timber.plant(circularLogTree)
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}