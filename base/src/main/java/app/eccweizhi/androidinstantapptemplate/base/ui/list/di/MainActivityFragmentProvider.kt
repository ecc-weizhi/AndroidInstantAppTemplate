package app.eccweizhi.androidinstantapptemplate.base.ui.list.di

import dagger.Module


@Module
abstract class MainActivityFragmentProvider {
    @MainActivityScope
    @ContributesAndroidInjector(modules = [(SalesLaunchFragmentModule::class)])
    abstract fun bindSalesLaunchFragment(): SalesLaunchFragment

    @AboutScope
    @ContributesAndroidInjector(modules = [(AboutFragmentModule::class)])
    abstract fun bindAboutFragment(): AboutFragment

}
