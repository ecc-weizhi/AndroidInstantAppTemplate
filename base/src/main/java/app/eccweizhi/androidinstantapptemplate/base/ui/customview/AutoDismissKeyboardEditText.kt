package app.eccweizhi.androidinstantapptemplate.base.ui.customview

import android.content.Context
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet
import app.eccweizhi.androidinstantapptemplate.base.ui.util.DismissKeyboardAttachStateChangeListener


class AutoDismissKeyboardEditText : AppCompatEditText {
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