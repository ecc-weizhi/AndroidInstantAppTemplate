package app.eccweizhi.androidinstantapptemplate.base.ui

import android.os.Bundle
import android.support.v4.app.Fragment


abstract class BaseKey: Key {
    override val fragmentTag: String
        get() = toString()

    override fun newFragment(): Fragment = createFragment().apply {
        arguments = (arguments ?: Bundle()).apply {
            putParcelable(BaseFragment.KEY_TAG, this@BaseKey)
        }
    }

    protected abstract fun createFragment(): Fragment
}