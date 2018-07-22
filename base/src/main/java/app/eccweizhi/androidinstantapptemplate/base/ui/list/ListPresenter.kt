package app.eccweizhi.androidinstantapptemplate.base.ui.list

import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService


class ListPresenter(
        private val view: Mvp.View,
        private val networkService: NetworkService
) : Mvp.Presenter {
    override fun onSpringClick(param: String) {
        view.goToSpring(param)
    }

    override fun onSummerClick(param: String) {
        view.goToSummer(param)
    }

    override fun onAutumnClick(param: String) {
        view.goToAutumn(param)
    }

    override fun onWinterClick(param: String) {
        view.goToWinter(param)
    }

}