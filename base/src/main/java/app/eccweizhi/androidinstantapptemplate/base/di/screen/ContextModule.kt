package app.eccweizhi.androidinstantapptemplate.base.di.screen

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides


@Module
class ContextModule {
    private val activity: Activity

    constructor(activity: Activity) {
        this.activity = activity
    }

    constructor(fragment: Fragment) {
        this.activity = fragment.activity!!
    }

    @Provides
    @ScreenScope
    fun providesActivity(): Activity {
        return activity
    }

    @Provides
    @ScreenScope
    fun providesContext(): Context {
        return activity
    }
}