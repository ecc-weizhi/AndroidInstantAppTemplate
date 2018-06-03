package app.eccweizhi.androidinstantapptemplate.base.network

import android.app.Application
import app.eccweizhi.androidinstantapptemplate.base.di.application.ApplicationScope
import javax.inject.Inject


/**
 * This is a dummy class that does nothing. [NetworkService] is supposed to represent a "service"
 * that is going to be injected via dagger.
 */
@ApplicationScope
class NetworkService @Inject constructor(val application: Application)