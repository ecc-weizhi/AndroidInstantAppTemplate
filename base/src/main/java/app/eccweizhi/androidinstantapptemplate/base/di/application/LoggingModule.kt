package app.eccweizhi.androidinstantapptemplate.base.di.application

import android.app.Application
import app.eccweizhi.onscreenlog.OnScreenLog
import dagger.Module
import dagger.Provides


@Module
class LoggingModule {
    @Provides
    @ApplicationScope
    fun providesOnScreenLog(application: Application): OnScreenLog {
        return OnScreenLog.builder()
                .context(application)
                .notificationId(1)
                .build()
    }
}