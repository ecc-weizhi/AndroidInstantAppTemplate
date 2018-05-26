package app.eccweizhi.androidinstantapptemplate.spring.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.main.MainActivity


class SpringActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.startWith(this,
                SpringFragment.SpringKey("foo"))
    }
}