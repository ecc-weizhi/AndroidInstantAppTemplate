package app.eccweizhi.androidinstantapptemplate.summer.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.main.MainActivity


class SummerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.startWith(this,
                SummerFragment.SummerKey("foo"))
    }
}