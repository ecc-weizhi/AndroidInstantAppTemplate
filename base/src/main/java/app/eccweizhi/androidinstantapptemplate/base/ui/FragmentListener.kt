package app.eccweizhi.androidinstantapptemplate.base.ui


interface FragmentListener {
    fun performAction(fragmentTag: String,
                      action: Action,
                      vararg data:Any)

    enum class Action{
        Navigate
    }
}