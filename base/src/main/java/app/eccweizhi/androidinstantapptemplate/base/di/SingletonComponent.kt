package app.eccweizhi.androidinstantapptemplate.base.di

import android.app.Application
import app.eccweizhi.androidinstantapptemplate.base.ui.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AndroidInjectionModule::class),
    (LoggingModule::class),
    (ActivityProvider::class)])
interface SingletonComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): SingletonComponent
    }

    fun inject(app: App)
}
