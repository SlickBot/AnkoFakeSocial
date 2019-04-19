package com.ulj.slicky.ankofakesocial.activity.detail

import android.support.constraint.ConstraintSet.PARENT_ID
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.color
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.matchConstraint
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by root on 7/13/17
 */
internal class DetailActivityUI :  AnkoComponent<DetailActivity> {

    lateinit var ownerImage: ImageView
    lateinit var ownerName: TextView
    lateinit var postedAt: TextView
    lateinit var detailText: TextView

    override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
        constraintLayout {

            ownerImage = imageView(R.drawable.ic_user) {
                id = R.id.detail_image
                contentDescription = "Profile photo of friend"
                onClick { owner.onOpenProfile() }
            }.lparams(dip(80), dip(80)) {
                margin = dip(24)
                topToTop = PARENT_ID
                startToStart = PARENT_ID
            }

            ownerName = textView {
                id = R.id.detail_owner_name
                textAppearance = R.style.TextAppearance_AppCompat_Large
            }.lparams(matchConstraint, wrapContent) {
                horizontalMargin = dip(24)
                topToTop = R.id.detail_image
                bottomToTop = R.id.detail_posted_at
                leftToRight = R.id.detail_image
                rightToRight = PARENT_ID
            }

            postedAt = textView {
                id = R.id.detail_posted_at
                textAppearance = R.style.TextAppearance_AppCompat_Small
                textColor = ctx.color(R.color.colorTextDark)
            }.lparams(matchConstraint, wrapContent) {
                horizontalMargin = dip(24)
                topToBottom = R.id.detail_owner_name
                bottomToBottom = R.id.detail_image
                leftToRight = R.id.detail_image
                rightToRight = PARENT_ID
            }

            scrollView {
                detailText = textView {
                    id = R.id.detail_text
                    textAppearance = R.style.TextAppearance_AppCompat_Large
                    gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(matchParent, wrapContent) {
                    margin = dip(24)
                }
            }.lparams(matchParent, wrapContent) {
                topToBottom = R.id.detail_image
            }

        }
    }

}
