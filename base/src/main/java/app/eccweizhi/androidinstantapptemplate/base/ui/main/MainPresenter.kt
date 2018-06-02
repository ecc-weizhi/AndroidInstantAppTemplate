package app.eccweizhi.androidinstantapptemplate.base.ui.main

import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService
import javax.inject.Inject


@MainActivityScope
class MainPresenter @Inject constructor(
        private val view: Mvp.View,
        private val networkService: NetworkService
) : Mvp.Presenter {
}