package com.ulj.slicky.ankofakesocial.activity.profile

import android.support.constraint.ConstraintSet.PARENT_ID
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.color
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout._ConstraintLayout
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.matchConstraint

/**
 * Created by root on 7/14/17
 */
@Suppress("MemberVisibilityCanBePrivate")
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
                    topToTop = PARENT_ID
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                nameTitle = textView("Name") {
                    id = R.id.profile_name_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_icon
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                name = textView {
                    id = R.id.profile_name
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_name_title
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                emailTitle = textView("Email") {
                    id = R.id.profile_email_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_name
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                email = textView {
                    id = R.id.profile_email
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_email_title
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                divider0 = divider {
                    id = R.id.profile_divider0
                }.lparams(matchConstraint, dip(3)) {
                    topMargin = dip(16)
                    topToBottom = R.id.profile_email
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                cellTitle = textView("Cell") {
                    id = R.id.profile_cell_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_divider0
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                cell = textView {
                    id = R.id.profile_cell
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_cell_title
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                phoneTitle = textView("Phone") {
                    id = R.id.profile_phone_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_cell
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                phone = textView {
                    id = R.id.profile_phone
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_phone_title
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                divider1 = divider {
                    id = R.id.profile_divider1
                }.lparams(matchConstraint, dip(3)) {
                    topMargin = dip(16)
                    topToBottom = R.id.profile_phone
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                birthdayTitle = textView("Birthday") {
                    id = R.id.profile_birthday_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_divider1
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                birthday = textView {
                    id = R.id.profile_birthday
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_birthday_title
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                registeredTitle = textView("Registered") {
                    id = R.id.profile_registered_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_birthday
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                registered = textView {
                    id = R.id.profile_registered
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_registered_title
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                divider2 = divider {
                    id = R.id.profile_divider2
                }.lparams(matchConstraint, dip(3)) {
                    topMargin = dip(16)
                    topToBottom = R.id.profile_registered
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                streetTitle = textView("Street") {
                    id = R.id.profile_street_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_divider2
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                street = textView {
                    id = R.id.profile_street
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_street_title
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                cityTitle = textView("City") {
                    id = R.id.profile_city_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_street
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                city = textView {
                    id = R.id.profile_city
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_city_title
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                stateTitle = textView("State") {
                    id = R.id.profile_state_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_city
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                state = textView {
                    id = R.id.profile_state
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(wrapContent, wrapContent) {
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_state_title
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                natTitle = textView("Country") {
                    id = R.id.profile_nat_title
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(wrapContent, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_state
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }

                nat = textView {
                    id = R.id.profile_nat
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(wrapContent, wrapContent) {
                    bottomMargin = dip(16)
                    horizontalMargin = dip(32)
                    topToBottom = R.id.profile_nat_title
                    bottomToBottom = PARENT_ID
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                }


            }.lparams(matchParent, wrapContent)
        }
    }

    private fun _ConstraintLayout.divider(init: (View.() -> Unit)? = null) = View(context).apply {
        backgroundResource = R.color.colorPrimaryDark
        init?.invoke(this)
    }.also { addView(it) }

}