package app.eccweizhi.androidinstantapptemplate.base.di.application

import app.eccweizhi.androidinstantapptemplate.base.logger.AppLog
import dagger.Module
import dagger.Provides


@Module
class LoggingModule {
    @Provides
    @ApplicationScope
    fun providesAppLog(): AppLog {
        return AppLog(30)
    }
}