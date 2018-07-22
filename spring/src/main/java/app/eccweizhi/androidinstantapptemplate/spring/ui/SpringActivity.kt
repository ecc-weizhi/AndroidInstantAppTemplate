package app.eccweizhi.androidinstantapptemplate.spring.ui

import android.os.Bundle
import app.eccweizhi.androidinstantapptemplate.base.ui.BaseActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.FeatureUriString
import app.eccweizhi.androidinstantapptemplate.base.ui.main.MainActivity
import app.eccweizhi.androidinstantapptemplate.spring.di.DaggerSpringComponent
import app.eccweizhi.androidinstantapptemplate.spring.ui.springone.SpringOneFragment
import javax.inject.Inject


class SpringActivity : BaseActivity() {
    @Inject
    protected lateinit var springStuff: SpringStuff

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerSpringComponent.builder()
                .screenComponent(screenComponent)
                .build()
                .inject(this)
        super.onCreate(savedInstanceState)

        val param1 = intent.getStringExtra(FeatureUriString.SPRING_INTENT_KEY_PARAM_1)
        MainActivity.startWith(this,
                SpringOneFragment.Key(param1))
    }

    companion object {
        const val LOG_TAG = "SpringActivity"
    }
}