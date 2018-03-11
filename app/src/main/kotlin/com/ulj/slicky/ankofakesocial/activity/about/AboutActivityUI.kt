package com.ulj.slicky.ankofakesocial.activity.about

import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.widget.ImageView.ScaleType.FIT_CENTER
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.color
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by root on 7/12/17
 */
internal class AboutActivityUI : AnkoComponent<AboutActivity> {

    override fun createView(ui: AnkoContext<AboutActivity>) = with(ui) {
        scrollView {
            constraintLayout {

                imageView(R.drawable.logo) {
                    id = R.id.about_app_logo
                    contentDescription = "App Logo"
                    scaleType = FIT_CENTER
                }.lparams(dip(160), dip(160)) {
                    topMargin = dip(32)
                    leftMargin = dip(32)
                    rightMargin = dip(32)
                    topToTop = PARENT_ID
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                textView("This app is powered by") {
                    id = R.id.about_powered_by
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(32)
                    leftMargin = dip(32)
                    rightMargin = dip(32)
                    topToBottom = R.id.about_app_logo
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                textView("randomuser.me") {
                    id = R.id.about_randomuser
                    textAppearance = R.style.TextAppearance_AppCompat_Large
                    onClick { owner.onRandomUserClick() }
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(40)
                    leftMargin = dip(32)
                    rightMargin = dip(32)
                    topToBottom = R.id.about_powered_by
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                textView("&") {
                    id = R.id.about_and
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    leftMargin = dip(32)
                    rightMargin = dip(32)
                    topToBottom = R.id.about_randomuser
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                textView("watchout4snakes.com") {
                    id = R.id.about_watchout
                    textAppearance = R.style.TextAppearance_AppCompat_Large
                    onClick { owner.onWatchOutClick() }
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    leftMargin = dip(32)
                    rightMargin = dip(32)
                    topToBottom = R.id.about_and
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

            }.lparams(matchParent, wrapContent)
        }
    }
}