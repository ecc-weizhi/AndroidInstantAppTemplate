package app.eccweizhi.androidinstantapptemplate.base.ui.settings


interface Mvp {
    interface View {
        fun showShowLog(showLog: Boolean)
    }

    interface Presenter {
        fun onStart()
        fun onStop(showLog: Boolean)
    }
}