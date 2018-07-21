package app.eccweizhi.androidinstantapptemplate.base.ui


interface FragmentListener {
    /**
     * @param frragmentTag tag of the fragment who call this method
     */
    fun performAction(fragmentTag: String,
                      action: Action,
                      vararg data:Any)

    enum class Action{
        NavigateToFeature,
        NavigateToScreen
    }
}