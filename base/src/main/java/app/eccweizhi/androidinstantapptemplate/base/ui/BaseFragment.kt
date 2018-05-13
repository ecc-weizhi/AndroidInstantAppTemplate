package app.eccweizhi.androidinstantapptemplate.base.ui

import android.support.v4.app.Fragment


abstract class BaseFragment: Fragment() {
    fun <K : Key> getKey(): K = arguments!!.getParcelable(KEY_TAG) as K

    companion object {
        const val KEY_TAG = "KEY"
    }
}