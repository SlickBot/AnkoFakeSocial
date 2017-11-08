package com.ulj.slicky.ankofakesocial.activity.login

import android.support.v4.view.ViewPager
import com.rd.PageIndicatorView
import com.rd.animation.type.AnimationType
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.color
import com.ulj.slicky.ankofakesocial.utils.constraintLayout
import com.ulj.slicky.ankofakesocial.utils.matchConstraint
import com.ulj.slicky.ankofakesocial.utils.pageIndicatorView
import com.ulj.slicky.ankofakesocial.utils.parentId
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.dip
import org.jetbrains.anko.support.v4.viewPager
import org.jetbrains.anko.wrapContent

/**
 * Created by root on 7/14/17
 */
internal class LoginActivityUI : AnkoComponent<LoginActivity> {

    lateinit var viewPager: ViewPager
    lateinit var indicator: PageIndicatorView

    override fun createView(ui: AnkoContext<LoginActivity>) = with(ui) {
        constraintLayout {
            viewPager = viewPager {
                id = R.id.login_container
            }.lparams(matchConstraint, matchConstraint) {
                bottomMargin = dip(8)
                topToTop = parentId
                bottomToTop = R.id.login_indicator
                endToEnd = parentId
                startToStart = parentId
            }
            indicator = pageIndicatorView {
                id = R.id.login_indicator
                //            gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                setAnimationType(AnimationType.SWAP)
                selectedColor = owner.color(R.color.colorAccent)
                unselectedColor = owner.color(R.color.colorPrimary)
            }.lparams(wrapContent, dip(24)) {
                bottomMargin = dip(8)
                topToBottom = R.id.login_container
                bottomToBottom = parentId
                endToEnd = parentId
                startToStart = parentId
            }
        }
    }
}