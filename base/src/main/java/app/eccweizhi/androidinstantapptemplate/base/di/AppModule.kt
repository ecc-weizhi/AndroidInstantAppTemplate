package app.eccweizhi.androidinstantapptemplate.base.di

import android.content.Context
import app.eccweizhi.androidinstantapptemplate.base.ui.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val app: App) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return app
    }
}