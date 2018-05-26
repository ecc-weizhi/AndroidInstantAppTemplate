package app.eccweizhi.androidinstantapptemplate.base.ui.list


interface Mvp {
    interface View {
        fun navigateTo(screenIdentifier: String)
    }

    interface Presenter {
        fun onSpringClick()
        fun onSummerClick()
        fun onAutumnClick()
        fun onWinterClick()
    }
}