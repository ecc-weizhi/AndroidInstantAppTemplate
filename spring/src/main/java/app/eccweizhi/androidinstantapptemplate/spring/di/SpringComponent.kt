package app.eccweizhi.androidinstantapptemplate.spring.di

import app.eccweizhi.androidinstantapptemplate.base.di.screen.ScreenComponent
import app.eccweizhi.androidinstantapptemplate.spring.ui.SpringActivity
import app.eccweizhi.androidinstantapptemplate.spring.ui.SpringStuff
import app.eccweizhi.androidinstantapptemplate.spring.ui.springone.SpringOneFragment
import app.eccweizhi.androidinstantapptemplate.spring.ui.springtwo.SpringTwoFragment
import dagger.Component


@SpringScope
@Component(dependencies = [ScreenComponent::class])
interface SpringComponent {
    fun inject(springActivity: SpringActivity)
    fun inject(springOneFragment: SpringOneFragment)
    fun inject(springTwoFragment: SpringTwoFragment)

    fun springStuff(): SpringStuff
}