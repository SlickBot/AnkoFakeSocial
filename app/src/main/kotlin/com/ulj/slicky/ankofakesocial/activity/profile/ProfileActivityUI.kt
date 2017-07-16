package com.ulj.slicky.ankofakesocial.activity.profile

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.color
import com.ulj.slicky.ankofakesocial.utils._ConstraintLayout
import com.ulj.slicky.ankofakesocial.utils.constraintLayout
import com.ulj.slicky.ankofakesocial.utils.matchConstraint
import com.ulj.slicky.ankofakesocial.utils.parentId
import org.jetbrains.anko.*

/**
 * Created by root on 7/14/17
 */
internal class ProfileActivityUI : AnkoComponent<ProfileActivity> {

    lateinit var icon: ImageView
    lateinit var nameTitle: TextView
    lateinit var name: TextView
    lateinit var emailTitle: TextView
    lateinit var email: TextView
    lateinit var cellTitle: TextView
    lateinit var cell: TextView
    lateinit var phoneTitle: TextView
    lateinit var phone: TextView
    lateinit var birthdayTitle: TextView
    lateinit var birthday: TextView
    lateinit var registeredTitle: TextView
    lateinit var registered: TextView
    lateinit var streetTitle: TextView
    lateinit var street: TextView
    lateinit var cityTitle: TextView
    lateinit var city: TextView
    lateinit var stateTitle: TextView
    lateinit var state: TextView
    lateinit var natTitle: TextView
    lateinit var nat: TextView

    lateinit var divider0: View
    lateinit var divider1: View
    lateinit var divider2: View

    override fun createView(ui: AnkoContext<ProfileActivity>) = with(ui) {
        scrollView {
            constraintLayout {

                icon = imageView(R.drawable.ic_user) {
                    id = R.id.profile_icon
                    contentDescription = "Profile photo"
                }.lparams(dip(200), dip(200)) {
                    margin = dip(32)
                    topToTop = parentId
                    startToStart = parentId
                    endToEnd = parentId
                }

                nameTitle = textView("Name") {
                    id = R.id.profile_name_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_icon
                    startToStart = parentId
                    endToEnd = parentId
                }

                name = textView {
                    id = R.id.profile_name
                    setTextAppearance(ctx, R.style.TextAppearance_AppCompat_Large)
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_name_title
                    startToStart = parentId
                    endToEnd = parentId
                }

                emailTitle = textView("Email") {
                    id = R.id.profile_email_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_name
                    startToStart = parentId
                    endToEnd = parentId
                }

                email = textView {
                    id = R.id.profile_email
                    setTextAppearance(ctx, R.style.TextAppearance_Medium)
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_email_title
                    startToStart = parentId
                    endToEnd = parentId
                }

                divider0 = divider {
                    id = R.id.profile_divider0
                }.lparams(matchConstraint, dip(3)) {
                    topMargin = dip(16)
                    topToBottom = R.id.profile_email
                    startToStart = parentId
                    endToEnd = parentId
                }

                cellTitle = textView("Cell") {
                    id = R.id.profile_cell_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_divider0
                    startToStart = parentId
                    endToEnd = parentId
                }

                cell = textView {
                    id = R.id.profile_cell
                    setTextAppearance(ctx, R.style.TextAppearance_Medium)
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_cell_title
                    startToStart = parentId
                    endToEnd = parentId
                }

                phoneTitle = textView("Phone") {
                    id = R.id.profile_phone_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_cell
                    startToStart = parentId
                    endToEnd = parentId
                }

                phone = textView {
                    id = R.id.profile_phone
                    setTextAppearance(ctx, R.style.TextAppearance_Medium)
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_phone_title
                    startToStart = parentId
                    endToEnd = parentId
                }

                divider1 = divider {
                    id = R.id.profile_divider1
                }.lparams(matchConstraint, dip(3)) {
                    topMargin = dip(16)
                    topToBottom = R.id.profile_phone
                    startToStart = parentId
                    endToEnd = parentId
                }

                birthdayTitle = textView("Birthday") {
                    id = R.id.profile_birthday_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_divider1
                    startToStart = parentId
                    endToEnd = parentId
                }

                birthday = textView {
                    id = R.id.profile_birthday
                    setTextAppearance(ctx, R.style.TextAppearance_Medium)
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_birthday_title
                    startToStart = parentId
                    endToEnd = parentId
                }

                registeredTitle = textView("Registered") {
                    id = R.id.profile_registered_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_birthday
                    startToStart = parentId
                    endToEnd = parentId
                }

                registered = textView {
                    id = R.id.profile_registered
                    setTextAppearance(ctx, R.style.TextAppearance_Medium)
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_registered_title
                    startToStart = parentId
                    endToEnd = parentId
                }

                divider2 = divider {
                    id = R.id.profile_divider2
                }.lparams(matchConstraint, dip(3)) {
                    topMargin = dip(16)
                    topToBottom = R.id.profile_registered
                    startToStart = parentId
                    endToEnd = parentId
                }

                streetTitle = textView("Street") {
                    id = R.id.profile_street_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_divider2
                    startToStart = parentId
                    endToEnd = parentId
                }

                street = textView {
                    id = R.id.profile_street
                    setTextAppearance(ctx, R.style.TextAppearance_Medium)
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_street_title
                    startToStart = parentId
                    endToEnd = parentId
                }

                cityTitle = textView("City") {
                    id = R.id.profile_city_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_street
                    startToStart = parentId
                    endToEnd = parentId
                }

                city = textView {
                    id = R.id.profile_city
                    setTextAppearance(ctx, R.style.TextAppearance_Medium)
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_city_title
                    startToStart = parentId
                    endToEnd = parentId
                }

                stateTitle = textView("State") {
                    id = R.id.profile_state_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_city
                    startToStart = parentId
                    endToEnd = parentId
                }

                state = textView {
                    id = R.id.profile_state
                    setTextAppearance(ctx, R.style.TextAppearance_AppCompat_Large)
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_state_title
                    startToStart = parentId
                    endToEnd = parentId
                }

                natTitle = textView("Country") {
                    id = R.id.profile_nat_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_state
                    startToStart = parentId
                    endToEnd = parentId
                }

                nat = textView {
                    id = R.id.profile_nat
                    setTextAppearance(ctx, R.style.TextAppearance_AppCompat_Large)
                }.lparams(wrapContent, wrapContent) {
                    bottomMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_nat_title
                    bottomToBottom = parentId
                    startToStart = parentId
                    endToEnd = parentId
                }


            }.lparams(matchParent, wrapContent)
        }
    }

    fun _ConstraintLayout.divider(init: (View.() -> Unit)? = null) = View(context).apply {
        backgroundResource = R.color.colorPrimaryDark
        init?.invoke(this)
    }.also { addView(it) }
}