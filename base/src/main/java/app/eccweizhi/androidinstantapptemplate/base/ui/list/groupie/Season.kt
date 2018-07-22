package app.eccweizhi.androidinstantapptemplate.base.ui.list.groupie

import android.content.Context
import app.eccweizhi.androidinstantapptemplate.base.R
import com.bumptech.glide.RequestManager
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_season.*


class Season private constructor(
        id: Long,
        private val title: CharSequence,
        private val subtitle: CharSequence,
        private val imgUrl: String,
        private val requestManager: RequestManager
) : Item(id) {
    override fun getLayout() = R.layout.item_season

    override fun bind(viewHolder: ViewHolder, position: Int) {
        requestManager.load(imgUrl).into(viewHolder.imageView)
        viewHolder.titleTextView.text = title
        viewHolder.subtitleTextView.text = subtitle
    }

    companion object {
        private const val springUrl = "https://i.imgur.com/H2y8Gq5.jpg"
        private const val summerUrl = "https://i.imgur.com/xBSSlP5.jpg"
        private const val autumnUrl = "https://i.imgur.com/ye9mLEB.jpg"
        private const val winterUrl = "https://i.imgur.com/am2zaMU.jpg"

        @JvmStatic
        fun spring(id: Long,
                   context: Context,
                   requestManager: RequestManager): Season {
            return Season(id,
                    context.getString(R.string.list_list_spring_title),
                    context.getString(R.string.list_list_spring_subtitle),
                    springUrl,
                    requestManager)
        }

        @JvmStatic
        fun summer(id: Long,
                   context: Context,
                   requestManager: RequestManager): Season {
            return Season(id,
                    context.getString(R.string.list_list_summer_title),
                    context.getString(R.string.list_list_summer_subtitle),
                    summerUrl,
                    requestManager)
        }

        @JvmStatic
        fun autumn(id: Long,
                   context: Context,
                   requestManager: RequestManager): Season {
            return Season(id,
                    context.getString(R.string.list_list_autumn_title),
                    context.getString(R.string.list_list_autumn_subtitle),
                    autumnUrl,
                    requestManager)
        }

        @JvmStatic
        fun winter(id: Long,
                   context: Context,
                   requestManager: RequestManager): Season {
            return Season(id,
                    context.getString(R.string.list_list_winter_title),
                    context.getString(R.string.list_list_winter_subtitle),
                    winterUrl,
                    requestManager)
        }
    }

}