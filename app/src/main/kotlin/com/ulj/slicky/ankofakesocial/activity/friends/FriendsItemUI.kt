package com.ulj.slicky.ankofakesocial.activity.friends

import android.content.res.ColorStateList
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.color
import com.ulj.slicky.ankofakesocial.utils.ChildComponent
import com.ulj.slicky.ankofakesocial.utils.cardView
import com.ulj.slicky.ankofakesocial.utils.constraintLayout
import com.ulj.slicky.ankofakesocial.utils.parentId
import org.jetbrains.anko.*

/**
 * Created by root on 7/13/17
 */
internal class FriendsItemUI(parent: ViewGroup) : ChildComponent(parent) {

    lateinit var image: ImageView
    lateinit var name: TextView
    lateinit var info: TextView

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        cardView {
            id = R.id.friends_item
            cardBackgroundColor = ColorStateList.valueOf(ctx.color(R.color.colorPrimaryDark))
            cardElevation = dip(4).toFloat()
            radius = dip(4).toFloat()

            lparams(matchParent, wrapContent) {
                margin = dip(8)
                setContentPadding(dip(8), dip(8), dip(8), dip(8))
            }

            constraintLayout {
                lparams(matchParent, wrapContent)

                image = imageView(R.drawable.ic_user) {
                    id = R.id.friend_image
                    contentDescription = "Profile photo of friend"
                }.lparams(dip(64), dip(64)) {
                    verticalMargin = dip(16)
                    dimensionRatio = "H, 1:1"
                    leftMargin = dip(16)
                    topToTop = parentId
                    bottomToBottom = parentId
                    leftToLeft = parentId
                }

                name = textView {
                    id = R.id.friend_name
                    setTextAppearance(context, R.style.TextAppearance_AppCompat_Large)
                    maxLines = 1
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(16)
                    topToTop = R.id.friend_image
                    bottomToTop = R.id.friend_info
                    leftToRight = R.id.friend_image
                }

                info = textView {
                    id = R.id.friend_info
                    textColor = ctx.color(R.color.colorTextDark)
                    maxLines = 1
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(16)
                    topToBottom = R.id.friend_name
                    bottomToBottom = R.id.friend_image
                    leftToRight = R.id.friend_image
                }
            }.lparams(matchParent, wrapContent)
        }
    }
}