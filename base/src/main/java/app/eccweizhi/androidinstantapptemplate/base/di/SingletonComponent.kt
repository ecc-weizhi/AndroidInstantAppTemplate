package app.eccweizhi.androidinstantapptemplate.base.di

import app.eccweizhi.androidinstantapptemplate.base.logger.CircularLogTree
import app.eccweizhi.androidinstantapptemplate.base.network.NetworkThing
import app.eccweizhi.androidinstantapptemplate.base.ui.App
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    (LoggingModule::class),
    (AppModule::class)])
interface SingletonComponent {
    fun inject(app: App)

    fun circularLogTree(): CircularLogTree
    fun networkThing(): NetworkThing
}
