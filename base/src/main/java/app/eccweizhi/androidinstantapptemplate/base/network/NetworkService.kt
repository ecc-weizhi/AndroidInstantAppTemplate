package app.eccweizhi.androidinstantapptemplate.base.network

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton


/**
 * This is a dummy class that does nothing. [NetworkService] is supposed to represent a "service"
 * that is going to be injected via dagger.
 */
@Singleton
class NetworkService @Inject constructor(val context: Context)