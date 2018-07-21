package app.eccweizhi.androidinstantapptemplate.autumn.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.main.MainActivity


class AutumnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.startWith(this,
                AutumnFragment.Key("foo"))
    }
}