package app.eccweizhi.androidinstantapptemplate.winter.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.FeatureUriString
import app.eccweizhi.androidinstantapptemplate.base.ui.main.MainActivity
import timber.log.Timber


class WinterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("WinterActivity onCreate taskId: %d", taskId)
        val param1 = intent.getStringExtra(FeatureUriString.WINTER_INTENT_KEY_PARAM_1)
        MainActivity.startWith(this, WinterFragment.Key(param1))
    }
}