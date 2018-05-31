package app.eccweizhi.androidinstantapptemplate.base.di

import app.eccweizhi.androidinstantapptemplate.base.logger.AppLog
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LoggingModule {
    @Provides
    @Singleton
    fun providesAppLog(): AppLog {
        return AppLog(30)
    }
}