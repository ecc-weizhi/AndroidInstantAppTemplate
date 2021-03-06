package app.eccweizhi.androidinstantapptemplate.spring.ui

import android.content.Context
import app.eccweizhi.androidinstantapptemplate.spring.di.SpringScope
import app.eccweizhi.onscreenlog.OnScreenLog
import javax.inject.Inject


/**
 * This is a dummy class that does nothing. [SpringStuff] is supposed to represent a an object
 * that is going to be injected via dagger and shared within spring module.
 */
@SpringScope
class SpringStuff @Inject constructor(
        private val context: Context,
        private val onScreenLog: OnScreenLog
) {
    companion object {
        private const val LOG_TAG = "SpringStuff"
    }
}