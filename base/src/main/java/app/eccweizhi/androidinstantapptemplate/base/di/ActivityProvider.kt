package app.eccweizhi.androidinstantapptemplate.base.di

import app.eccweizhi.androidinstantapptemplate.base.ui.MainActivity
import app.eccweizhi.androidinstantapptemplate.base.ui.list.di.MainActivityModule
import app.eccweizhi.androidinstantapptemplate.base.ui.list.di.MainActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityProvider {
    @MainActivityScope
    @ContributesAndroidInjector(modules = [(MainActivityModule::class),
        (MainActivityFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity
}
