package app.eccweizhi.androidinstantapptemplate.base.di

import app.eccweizhi.androidinstantapptemplate.base.logger.CircularLog
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LoggingModule {
    @Provides
    @Singleton
    fun providesCircularLog(): CircularLog {
        return CircularLog(30)
    }
}