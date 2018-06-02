package app.eccweizhi.androidinstantapptemplate.base.ui.main

import app.eccweizhi.androidinstantapptemplate.base.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_log.*


class LogItem(id: Long,
              private val tag: String?,
              private val message: String?) : Item(id) {

    override fun bind(viewHolder: ViewHolder,
                      position: Int) {
        viewHolder.tagTextView.text = tag
        viewHolder.messageTextView.text = message
    }

    override fun getLayout(): Int = R.layout.item_log
}