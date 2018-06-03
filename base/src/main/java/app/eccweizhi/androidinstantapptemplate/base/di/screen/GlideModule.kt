package app.eccweizhi.androidinstantapptemplate.base.di.screen

import android.app.Activity
import android.support.v4.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides


@Module
class GlideModule {
    private var activity: Activity? = null
    private var fragment: Fragment? = null

    constructor(activity: Activity) {
        this.activity = activity
    }

    constructor(fragment: Fragment) {
        this.fragment = fragment
    }

    @Provides
    fun providesRequestManager(): RequestManager {
        fragment?.let {
            return Glide.with(it)
        }

        activity?.let {
            return Glide.with(it)
        }

        throw IllegalStateException("Both fragment and activity are null. This should not happen")
    }
}