package app.eccweizhi.androidinstantapptemplate.base.ui

import android.support.annotation.StringRes


interface FragmentListener {
    /**
     * @param frragmentTag tag of the fragment who call this method
     */
    fun performAction(action: Action,
                      vararg data:Any)

    fun setScreenName(@StringRes titleResId: Int,
                      @StringRes subtitleResId: Int)

    fun setScreenName(title: CharSequence?,
                      subtitle: CharSequence?)

    enum class Action{
        NavigateToFeature,
        NavigateToScreen
    }
}