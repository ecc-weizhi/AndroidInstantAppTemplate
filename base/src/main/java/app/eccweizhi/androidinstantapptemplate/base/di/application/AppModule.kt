package app.eccweizhi.androidinstantapptemplate.base.di.application

import android.app.Application
import app.eccweizhi.androidinstantapptemplate.base.ui.App
import dagger.Module
import dagger.Provides


@Module
class AppModule(private val app: App) {
    @ApplicationScope
    @Provides
    fun provideContext(): Application {
        return app
    }
}