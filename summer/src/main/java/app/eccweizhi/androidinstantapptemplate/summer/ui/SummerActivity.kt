package app.eccweizhi.androidinstantapptemplate.summer.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.FeatureUriString
import app.eccweizhi.androidinstantapptemplate.base.ui.main.MainActivity


class SummerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val param1 = intent.getStringExtra(FeatureUriString.SUMMER_INTENT_KEY_PARAM_1)
        MainActivity.startWith(this, SummerFragment.Key(param1))
    }
}