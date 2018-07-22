package app.eccweizhi.androidinstantapptemplate.base.ui.main

import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService


class MainPresenter(
        private val view: Mvp.View,
        private val networkService: NetworkService
) : Mvp.Presenter