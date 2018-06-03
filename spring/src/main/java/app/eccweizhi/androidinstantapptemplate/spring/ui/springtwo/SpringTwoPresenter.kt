package app.eccweizhi.androidinstantapptemplate.spring.ui.springtwo

import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService


class SpringTwoPresenter(
        private val view: Mvp.View,
        private val networkService: NetworkService
) : Mvp.Presenter {
}