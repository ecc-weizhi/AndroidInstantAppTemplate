package app.eccweizhi.androidinstantapptemplate.base.ui.list

import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService
import app.eccweizhi.androidinstantapptemplate.base.ui.FeatureUriString


class ListPresenter(
        private val view: Mvp.View,
        private val networkService: NetworkService
) : Mvp.Presenter {
    override fun onSpringClick() {
        view.goToFeature(FeatureUriString.SPRING)
    }

    override fun onSummerClick() {
        view.goToFeature(FeatureUriString.SUMMER)
    }

    override fun onAutumnClick() {
        view.goToFeature(FeatureUriString.AUTUMN)
    }

    override fun onWinterClick() {
        view.goToFeature(FeatureUriString.WINTER)
    }

}