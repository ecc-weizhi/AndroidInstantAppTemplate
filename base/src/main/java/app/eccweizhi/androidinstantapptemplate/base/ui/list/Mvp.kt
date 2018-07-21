package app.eccweizhi.androidinstantapptemplate.base.ui.list


interface Mvp {
    interface View {
        fun goToFeature(featureUri: String)
    }

    interface Presenter {
        fun onSpringClick()
        fun onSummerClick()
        fun onAutumnClick()
        fun onWinterClick()
    }
}