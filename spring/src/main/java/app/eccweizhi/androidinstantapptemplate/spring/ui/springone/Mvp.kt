package app.eccweizhi.androidinstantapptemplate.spring.ui.springone


interface Mvp {
    interface View {
        fun goToSpringTwo()
    }

    interface Presenter {
        fun onGoToSpringTwoClick()
    }
}