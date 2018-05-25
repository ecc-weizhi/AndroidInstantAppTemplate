package app.eccweizhi.androidinstantapptemplate.base.ui.list

import app.eccweizhi.androidinstantapptemplate.base.network.NetworkThing
import javax.inject.Inject


class ListPresenter @Inject constructor(private val view: Mvp.View,
                                        private val networkThing: NetworkThing) : Mvp.Presenter {

}