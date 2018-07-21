package app.eccweizhi.androidinstantapptemplate.base.persistence

import app.eccweizhi.androidinstantapptemplate.base.di.application.ApplicationScope
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject


@ApplicationScope
class Store @Inject constructor(settingsPref: SettingsPref) {
    private val settingsPref = settingsPref

    fun readSettingsShowLog(): BehaviorSubject<Boolean> {
        return settingsPref.readShowLog()
    }

    fun writeSettingsShowLog(showLog: Boolean) {
        settingsPref.writeShowLog(showLog)
    }
}