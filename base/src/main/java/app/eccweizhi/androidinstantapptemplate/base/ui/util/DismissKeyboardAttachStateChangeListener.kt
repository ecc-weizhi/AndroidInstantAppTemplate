package app.eccweizhi.androidinstantapptemplate.base.ui.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


class DismissKeyboardAttachStateChangeListener() : View.OnAttachStateChangeListener {
    override fun onViewDetachedFromWindow(v: View) {
        val imm = v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken,
                InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    override fun onViewAttachedToWindow(v: View) {
        // No-op
    }
}