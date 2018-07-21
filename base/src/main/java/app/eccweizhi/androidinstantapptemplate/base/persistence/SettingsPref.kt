package app.eccweizhi.androidinstantapptemplate.base.persistence

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import app.eccweizhi.androidinstantapptemplate.base.di.application.ApplicationScope
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

@ApplicationScope
class SettingsPref @Inject constructor(val application: Application) {
    private val settingsPref: SharedPreferences = application.getSharedPreferences(SETTINGS_FILE,
            Context.MODE_PRIVATE)
    private val showLogSubject: BehaviorSubject<Boolean> by lazy {
        BehaviorSubject.createDefault(settingsPref.getBoolean(KEY_SHOW_LOG, false))
    }

    fun readShowLog(): BehaviorSubject<Boolean> {
        return showLogSubject
    }

    fun writeShowLog(showLog: Boolean) {
        settingsPref.edit()
                .putBoolean(KEY_SHOW_LOG, showLog)
                .apply()
        showLogSubject.onNext(settingsPref.getBoolean(KEY_SHOW_LOG, false))
    }

    private companion object {
        private const val SETTINGS_FILE = "settingsPreference"

        private const val KEY_SHOW_LOG = "show_log"
    }
}