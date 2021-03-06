package com.ulj.slicky.ankofakesocial.activity.content

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.activity.detail.DetailActivity.Companion.startDetail
import com.ulj.slicky.ankofakesocial.formattedWithTime
import com.ulj.slicky.ankofakesocial.fullName
import com.ulj.slicky.ankofakesocial.isAppiumTest
import com.ulj.slicky.ankofakesocial.model.content.Content
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import java.util.*

/**
 * Created by SlickyPC on 19.5.2017
 */
internal class ContentAdapter(private val activity: ContentActivity,
                              private val recycler: RecyclerView)
    : RecyclerView.Adapter<ContentViewHolder>() {

    internal var contents = listOf<Content>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val item = ContentItemUI(parent)

        item.view.setOnClickListener {
            val itemPosition = recycler.getChildLayoutPosition(item.view)
            val newContent = contents[itemPosition]
            activity.startDetail(newContent)
        }

        return ContentViewHolder(item)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val newContent = contents[position]
        val owner = newContent.owner
        val date = Date(newContent.postedAt)

        with(holder) {
            ownerName.text = owner.fullName()
            postedAt.text = date.formattedWithTime()
            content.text = newContent.text

            if (isAppiumTest()) {
                Picasso.with(activity)
                        .load(R.drawable.test_img)
                        .placeholder(R.drawable.ic_user)
                        .transform(CropCircleTransformation())
                        .into(ownerImage)
            } else {
                Picasso.with(activity)
                        .load(owner.picture.medium)
                        .placeholder(R.drawable.ic_user)
                        .transform(CropCircleTransformation())
                        .into(ownerImage)
            }
        }
    }

    override fun getItemCount() = contents.size

}
