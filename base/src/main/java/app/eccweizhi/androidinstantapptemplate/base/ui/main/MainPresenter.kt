package app.eccweizhi.androidinstantapptemplate.base.ui.main

import app.eccweizhi.androidinstantapptemplate.base.network.NetworkThing
import javax.inject.Inject


class MainPresenter @Inject constructor(private val view: Mvp.View,
                                        private val networkThing: NetworkThing) : Mvp.Presenter {
}