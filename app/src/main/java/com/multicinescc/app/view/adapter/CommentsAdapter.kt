package com.multicinescc.app.view.adapter

import android.view.View
import com.multicinescc.app.R
import com.multicinescc.app.models.CommentView
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentsAdapter : RootAdapter<CommentView>() {

    override val itemLayoutId: Int = R.layout.item_comment

    override fun viewHolder(view: View): RootViewHolder<CommentView> = ViewHolder(view)

    class ViewHolder(view: View) : RootViewHolder<CommentView>(itemView = view) {
        override fun bind(model: CommentView) {
            itemView.comment.text = model.value
            itemView.date.text = model.createdDate
        }
    }

}