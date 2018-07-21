package app.eccweizhi.androidinstantapptemplate.winter.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.main.MainActivity


class WinterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.startWith(this,
                WinterFragment.Key("foo"))
        finish()
    }
}