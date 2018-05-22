package app.eccweizhi.androidinstantapptemplate.featuretwo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import app.eccweizhi.androidinstantapptemplate.base.ui.MainActivity


class FeatureTwoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "FeatureTwoActivity onCreate", Toast.LENGTH_SHORT).show()

        MainActivity.startWith(this,
                FeatureTwoFragment.FeatureTwoKey("foo"))
    }
}