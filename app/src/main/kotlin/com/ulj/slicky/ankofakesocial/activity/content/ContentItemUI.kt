package com.ulj.slicky.ankofakesocial.activity.content

import android.content.res.ColorStateList
import android.support.constraint.ConstraintSet.PARENT_ID
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.color
import com.ulj.slicky.ankofakesocial.view.ChildComponent
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.matchConstraint

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
            setCardBackgroundColor(ColorStateList.valueOf(ctx.color(R.color.colorPrimaryDark)))
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
                    topToTop = PARENT_ID
                    bottomToBottom = PARENT_ID
                    startToStart = PARENT_ID
                }

                name = textView {
                    id = R.id.content_owner_name
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(16)
                    topToTop = PARENT_ID
                    startToEnd = R.id.content_owner_image
                }

                content = textView {
                    id = R.id.content_content
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(matchConstraint, wrapContent) {
                    horizontalMargin = dip(16)
                    topToBottom = R.id.content_owner_name
                    startToEnd = R.id.content_owner_image
                    endToEnd = PARENT_ID
                }

                postedAt = textView {
                    id = R.id.content_posted_at
                    textColor = ctx.color(R.color.colorTextDark)
                    maxLines = 1
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(16)
                    topToBottom = R.id.content_content
                    endToEnd = PARENT_ID
                }

            }.lparams(matchParent, wrapContent)
        }
    }

}
