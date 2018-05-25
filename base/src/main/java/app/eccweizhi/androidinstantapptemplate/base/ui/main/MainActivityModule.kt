package app.eccweizhi.androidinstantapptemplate.base.ui.main

import dagger.Module
import dagger.Provides


@Module
class MainActivityModule(private val mainActivity: MainActivity) {

    @Provides
    fun providesView(): Mvp.View {
        return mainActivity
    }

    @Provides
    fun providesPresenter(mainPresenter: MainPresenter): Mvp.Presenter {
        return mainPresenter
    }
}