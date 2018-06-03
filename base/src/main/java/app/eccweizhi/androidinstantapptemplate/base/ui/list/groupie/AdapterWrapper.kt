package app.eccweizhi.androidinstantapptemplate.base.ui.list.groupie

import android.content.Context
import android.view.View
import com.bumptech.glide.RequestManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.ViewHolder

class AdapterWrapper(
        context: Context,
        requestManager: RequestManager
) : OnItemClickListener {
    val adapter = GroupAdapter<ViewHolder>()
    var listener: Listener? = null

    init {
        adapter.setOnItemClickListener(this)

        adapter.add(Season.spring(ID_SPRING, context, requestManager))
        adapter.add(Season.summer(ID_SUMMER, context, requestManager))
        adapter.add(Season.autumn(ID_AUTUMN, context, requestManager))
        adapter.add(Season.winter(ID_WINTER, context, requestManager))
    }

    override fun onItemClick(item: Item<*>, view: View) {
        when (item.id) {
            ID_SPRING -> listener?.onSpringClick()
            ID_SUMMER -> listener?.onSummerClick()
            ID_AUTUMN -> listener?.onAutumnClick()
            ID_WINTER -> listener?.onWinterClick()
        }
    }

    interface Listener {
        fun onSpringClick()
        fun onSummerClick()
        fun onAutumnClick()
        fun onWinterClick()
    }

    companion object {
        private const val ID_SPRING = 1L
        private const val ID_SUMMER = 2L
        private const val ID_AUTUMN = 3L
        private const val ID_WINTER = 4L
    }
}