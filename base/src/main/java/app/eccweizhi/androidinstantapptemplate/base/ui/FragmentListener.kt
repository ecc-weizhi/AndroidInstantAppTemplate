package app.eccweizhi.androidinstantapptemplate.base.ui


interface FragmentListener {
    fun performAction(action: Action,
                      vararg data:Any)

    fun setScreenName(title: CharSequence?,
                      subtitle: CharSequence?)

    enum class Action{
        NavigateToFeature,
        NavigateToScreen
    }
}