package app.eccweizhi.androidinstantapptemplate.base.ui


interface FragmentListener {
    /**
     * @param frragmentTag tag of the fragment who call this method
     */
    fun performAction(action: Action,
                      vararg data:Any)

    fun setScreenName(title: CharSequence?,
                      subtitle: CharSequence?)

    enum class Action{
        NavigateToFeature,
        NavigateToScreen
    }
}