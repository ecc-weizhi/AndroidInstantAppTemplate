package app.eccweizhi.androidinstantapptemplate.base.ui.settings

import app.eccweizhi.androidinstantapptemplate.base.persistence.Store


class SettingsPresenter(private val view: Mvp.View,
                        private val store: Store) : Mvp.Presenter {
    override fun onStart() {
        val subject = store.readSettingsShowLog()
        view.showShowLog(subject.value)
    }

    override fun onStop(showLog: Boolean) {
        store.writeSettingsShowLog(showLog)
    }
}