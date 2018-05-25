package app.eccweizhi.androidinstantapptemplate.base.ui.list


import dagger.Module
import dagger.Provides


@Module
class ListFragmentModule(private val listFragment: ListFragment) {

    @Provides
    fun providesView(): Mvp.View {
        return listFragment
    }

    @Provides
    fun providesPresenter(listPresenter: ListPresenter): Mvp.Presenter {
        return listPresenter
    }
}