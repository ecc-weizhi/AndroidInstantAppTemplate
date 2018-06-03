package app.eccweizhi.androidinstantapptemplate.spring.ui.springone

import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService


class SpringOnePresenter(
        private val view: Mvp.View,
        private val networkService: NetworkService
) : Mvp.Presenter {
}