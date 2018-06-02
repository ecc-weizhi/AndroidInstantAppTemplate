package app.eccweizhi.androidinstantapptemplate.base.ui.list


import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides


@Module
class ListFragmentModule(private val listFragment: ListFragment) {

    @ListFragmentScope
    @Provides
    fun providesView(): Mvp.View {
        return listFragment
    }

    @ListFragmentScope
    @Provides
    fun providesPresenter(listPresenter: ListPresenter): Mvp.Presenter {
        return listPresenter
    }

    @ListFragmentScope
    @Provides
    fun providesRequestManager(): RequestManager {
        return Glide.with(listFragment)
    }
}