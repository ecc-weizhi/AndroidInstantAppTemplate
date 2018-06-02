package app.eccweizhi.androidinstantapptemplate.base.ui.main

import app.eccweizhi.androidinstantapptemplate.base.di.SingletonComponent
import dagger.Component


@MainActivityScope
@Component(modules = [MainActivityModule::class],
        dependencies = [SingletonComponent::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}