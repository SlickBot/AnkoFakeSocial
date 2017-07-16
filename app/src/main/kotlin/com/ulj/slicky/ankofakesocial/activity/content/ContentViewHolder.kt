package com.ulj.slicky.ankofakesocial.activity.content

import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by SlickyPC on 19.5.2017
 */
internal class ContentViewHolder(item: ContentItemUI) : RecyclerView.ViewHolder(item.view) {
    val ownerImage: ImageView = item.image
    val ownerName: TextView = item.name
    val content: TextView = item.content
    val postedAt: TextView = item.postedAt
}
