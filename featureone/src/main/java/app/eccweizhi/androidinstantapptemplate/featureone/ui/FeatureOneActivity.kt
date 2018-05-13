package app.eccweizhi.androidinstantapptemplate.featureone.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.eccweizhi.androidinstantapptemplate.ui.main.MainActivity
import timber.log.Timber


class FeatureOneActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate")

        MainActivity.startWith(this,
                FeatureOneFragment.FeatureOneKey("foo"))
    }
}