package app.eccweizhi.androidinstantapptemplate.ui


interface FragmentListener {
    fun performAction(fragmentTag: String,
                      action: Action,
                      vararg data:Any)

    enum class Action{
        Navigate
    }
}