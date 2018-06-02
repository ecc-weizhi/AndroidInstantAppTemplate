package app.eccweizhi.androidinstantapptemplate.base.ui.main

import dagger.Module
import dagger.Provides


@Module
class MainActivityModule(private val mainActivity: MainActivity) {

    @MainActivityScope
    @Provides
    fun providesView(): Mvp.View {
        return mainActivity
    }

    @MainActivityScope
    @Provides
    fun providesPresenter(mainPresenter: MainPresenter): Mvp.Presenter {
        return mainPresenter
    }
}