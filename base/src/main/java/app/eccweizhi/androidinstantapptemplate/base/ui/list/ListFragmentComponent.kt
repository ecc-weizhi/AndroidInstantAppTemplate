package app.eccweizhi.androidinstantapptemplate.base.ui.list

import app.eccweizhi.androidinstantapptemplate.base.di.SingletonComponent
import dagger.Component


@ListFragmentScope
@Component(modules = [ListFragmentModule::class],
        dependencies = [SingletonComponent::class])
interface ListFragmentComponent {
    fun inject(listFragment: ListFragment)
}