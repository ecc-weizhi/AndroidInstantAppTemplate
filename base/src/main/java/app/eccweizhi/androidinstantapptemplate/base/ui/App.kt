package app.eccweizhi.androidinstantapptemplate.base.ui

import android.app.Application
import app.eccweizhi.androidinstantapptemplate.base.BuildConfig
import app.eccweizhi.androidinstantapptemplate.base.di.AppModule
import app.eccweizhi.androidinstantapptemplate.base.di.DaggerSingletonComponent
import app.eccweizhi.androidinstantapptemplate.base.di.LoggingModule
import app.eccweizhi.androidinstantapptemplate.base.di.SingletonComponent
import timber.log.Timber


class App : Application() {
    val componentMap = mutableMapOf<String, Any>()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        val singletonComponent = getSingletonComponent()
        singletonComponent.inject(this)

        // logging should always be the first thing to be setup
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun getSingletonComponent(): SingletonComponent {
        val componentKey = SingletonComponent::class.java.canonicalName
        val cached = componentMap[componentKey]

        val component: SingletonComponent = if (cached == null) {
            val newComponent = DaggerSingletonComponent.builder()
                    .appModule(AppModule(this))
                    .loggingModule(LoggingModule())
                    .build()
            componentMap[componentKey] = newComponent
            newComponent
        } else {
            cached as SingletonComponent
        }
        return component
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}