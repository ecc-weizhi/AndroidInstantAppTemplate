package app.eccweizhi.androidinstantapptemplate.base.ui.customview

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.widget.EditText
import app.eccweizhi.androidinstantapptemplate.base.ui.util.DismissKeyboardAttachStateChangeListener


class AutoDismissKeyboardEditText : EditText {
    private var dimissKeyboardAttachStateChangeListener: DismissKeyboardAttachStateChangeListener? = null

    constructor(context: Context) : super(context)

    constructor(context: Context,
                attrs: AttributeSet) : super(context,
            attrs)

    constructor(context: Context,
                attrs: AttributeSet,
                defStyleAttr: Int) : super(context,
            attrs,
            defStyleAttr)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context,
                attrs: AttributeSet,
                defStyleAttr: Int,
                defStyleRes: Int) : super(context,
            attrs,
            defStyleAttr,
            defStyleRes)

    fun enableAutoDismissKeyboard(enable: Boolean) {
        if (enable && dimissKeyboardAttachStateChangeListener == null) {
            // going from disable -> enable
            val listener = DismissKeyboardAttachStateChangeListener()
            addOnAttachStateChangeListener(listener)
            dimissKeyboardAttachStateChangeListener = listener
        } else if (!enable && dimissKeyboardAttachStateChangeListener != null) {
            // going from enable -> disable
            removeOnAttachStateChangeListener(dimissKeyboardAttachStateChangeListener)
            dimissKeyboardAttachStateChangeListener = null
        }
    }

    override fun addOnAttachStateChangeListener(listener: OnAttachStateChangeListener?) {
        if (listener is DismissKeyboardAttachStateChangeListener) {
            if (dimissKeyboardAttachStateChangeListener == null) {
                dimissKeyboardAttachStateChangeListener = listener
                super.addOnAttachStateChangeListener(listener)
            } else {
                // No-op
            }
        } else {
            super.addOnAttachStateChangeListener(listener)
        }
    }

    override fun removeOnAttachStateChangeListener(listener: OnAttachStateChangeListener?) {
        if (listener is DismissKeyboardAttachStateChangeListener) {
            super.removeOnAttachStateChangeListener(listener)

            if (listener.equals(dimissKeyboardAttachStateChangeListener)) {
                dimissKeyboardAttachStateChangeListener = null
            }
        } else {
            super.removeOnAttachStateChangeListener(listener)
        }
    }
}