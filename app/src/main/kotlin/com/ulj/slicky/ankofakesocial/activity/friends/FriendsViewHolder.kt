package com.ulj.slicky.ankofakesocial.activity.friends

import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by SlickyPC on 24.5.2017
 */
internal class FriendsViewHolder(val item: FriendsItemUI) : RecyclerView.ViewHolder(item.view) {
    val friendImage: ImageView = item.image
    val friendName: TextView = item.name
    val friendInfo: TextView = item.info
}
