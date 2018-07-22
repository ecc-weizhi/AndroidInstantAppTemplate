package app.eccweizhi.androidinstantapptemplate.base.persistence

import app.eccweizhi.androidinstantapptemplate.base.di.application.ApplicationScope
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject


@ApplicationScope
class Store @Inject constructor(private val settingsPref: SettingsPref) {
    fun readSettingsShowLog(): BehaviorSubject<Boolean> {
        return settingsPref.readShowLog()
    }

    fun writeSettingsShowLog(showLog: Boolean) {
        settingsPref.writeShowLog(showLog)
    }
}