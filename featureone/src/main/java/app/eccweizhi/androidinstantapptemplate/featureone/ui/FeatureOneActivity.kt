package app.eccweizhi.androidinstantapptemplate.featureone.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import app.eccweizhi.androidinstantapptemplate.base.ui.MainActivity


class FeatureOneActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "FeatureOneActivity onCreate", Toast.LENGTH_SHORT).show()

        MainActivity.startWith(this,
                FeatureOneFragment.FeatureOneKey("foo"))
    }
}