package app.eccweizhi.androidinstantapptemplate.base.ui.list


interface Mvp {
    interface View {
        fun goToSpring(param: String)
        fun goToSummer(param: String)
        fun goToAutumn(param: String)
        fun goToWinter(param: String)
    }

    interface Presenter {
        fun onSpringClick(param: String)
        fun onSummerClick(param: String)
        fun onAutumnClick(param: String)
        fun onWinterClick(param: String)
    }
}