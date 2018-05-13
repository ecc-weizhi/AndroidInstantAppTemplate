package app.eccweizhi.androidinstantapptemplate.featuretwo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.main.MainActivity
import timber.log.Timber


class FeatureTwoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate")

        MainActivity.startWith(this,
                FeatureTwoFragment.FeatureTwoKey("foo"))
    }
}