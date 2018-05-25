package app.eccweizhi.androidinstantapptemplate.base.logger

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CircularLogTree @Inject constructor(private val circularLog: CircularLog) : Timber.Tree() {

    override fun log(priority: Int,
                     tag: String?,
                     message: String?,
                     t: Throwable?) {
        circularLog.enqueue(Message(System.currentTimeMillis(), tag, message))
    }
}
