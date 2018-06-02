package app.eccweizhi.androidinstantapptemplate.base.ui.list

import app.eccweizhi.androidinstantapptemplate.base.network.NetworkService
import app.eccweizhi.androidinstantapptemplate.base.ui.ScreenIdentifier
import javax.inject.Inject


@ListFragmentScope
class ListPresenter @Inject constructor(
        private val view: Mvp.View,
        private val networkService: NetworkService
) : Mvp.Presenter {
    override fun onSpringClick() {
        view.navigateTo(ScreenIdentifier.URI_FEATURE_SPRING)
    }

    override fun onSummerClick() {
        view.navigateTo(ScreenIdentifier.URI_FEATURE_SUMMER)
    }

    override fun onAutumnClick() {
        view.navigateTo(ScreenIdentifier.URI_FEATURE_AUTUMN)
    }

    override fun onWinterClick() {
        view.navigateTo(ScreenIdentifier.URI_FEATURE_WINTER)
    }

}