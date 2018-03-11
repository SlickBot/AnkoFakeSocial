package com.ulj.slicky.ankofakesocial.activity.content

import android.content.res.ColorStateList
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.color
import com.ulj.slicky.ankofakesocial.utils.*
import org.jetbrains.anko.*

/**
 * Created by root on 7/15/17
 */
internal class ContentItemUI(parent: ViewGroup) : ChildComponent(parent) {

    lateinit var image: ImageView
    lateinit var name: TextView
    lateinit var content: TextView
    lateinit var postedAt: TextView

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        cardView {
            id = R.id.content_item
            cardBackgroundColorList = ColorStateList.valueOf(ctx.color(R.color.colorPrimaryDark))
            cardElevation = dip(4).toFloat()
            radius = dip(4).toFloat()

            lparams(matchParent, wrapContent) {
                margin = dip(8)
                setContentPadding(dip(8), dip(8), dip(8), dip(8))
            }

            constraintLayout {

                image = imageView(R.drawable.ic_user) {
                    id = R.id.content_owner_image
                    contentDescription = "Profile photo of friend"
                }.lparams(dip(64), dip(64)) {
                    topMargin = dip(16)
                    horizontalMargin = dip(16)
                    topToTop = parentId
                    bottomToBottom = parentId
                    startToStart = parentId
                }

                name = textView {
                    id = R.id.content_owner_name
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(16)
                    topToTop = parentId
                    startToEnd = R.id.content_owner_image
                }

                content = textView {
                    id = R.id.content_content
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(matchConstraint, wrapContent) {
                    horizontalMargin = dip(16)
                    topToBottom = R.id.content_owner_name
                    startToEnd = R.id.content_owner_image
                    endToEnd = parentId
                }

                postedAt = textView {
                    id = R.id.content_posted_at
                    textColor = ctx.color(R.color.colorTextDark)
                    maxLines = 1
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(16)
                    topToBottom = R.id.content_content
                    endToEnd = parentId
                }

            }.lparams(matchParent, wrapContent)
        }
    }
}