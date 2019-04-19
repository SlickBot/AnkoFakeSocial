package com.ulj.slicky.ankofakesocial.activity.settings

import android.support.constraint.ConstraintSet.PARENT_ID
import android.text.InputType
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import com.ulj.slicky.ankofakesocial.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.matchConstraint

/**
 * Created by root on 7/14/17
 */
@Suppress("MemberVisibilityCanBePrivate")
internal class SettingsActivityUI : AnkoComponent<SettingsActivity> {

    lateinit var onOffText: TextView
    lateinit var onOffSubtext: TextView
    lateinit var onOffSwitch: Switch

    lateinit var durationText: TextView
    lateinit var durationSubtext: TextView
    lateinit var durationField: EditText

    lateinit var randomText: TextView
    lateinit var randomSubtext: TextView
    lateinit var randomSwitch: Switch

    override fun createView(ui: AnkoContext<SettingsActivity>) = with(ui) {
        scrollView {
            constraintLayout {

                onOffText = textView("Notifications state") {
                    id = R.id.settings_on_off_text
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(matchConstraint, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(16)
                    topToTop = PARENT_ID
                    startToStart = PARENT_ID
                    endToStart = R.id.settings_on_off_switch
                }

                onOffSubtext = textView("When turned on, it will start delayed notify service") {
                    id = R.id.settings_on_off_subtext
                    textAppearance = R.style.TextAppearance_Small
                }.lparams(matchConstraint, wrapContent) {
                    horizontalMargin = dip(16)
                    topToBottom = R.id.settings_on_off_text
                    startToStart = PARENT_ID
                    endToStart = R.id.settings_on_off_switch
                }

                onOffSwitch = themedSwitch(R.style.AppTheme_Switch) {
                    id = R.id.settings_on_off_switch
                }.lparams(dip(80), wrapContent) {
                    margin = dip(16)
                    topToTop = R.id.settings_on_off_text
                    bottomToBottom = R.id.settings_on_off_subtext
                    endToEnd = PARENT_ID
                }

                durationText = textView("Delay duration") {
                    id = R.id.settings_duration_text
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(matchConstraint, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(16)
                    topToBottom = R.id.settings_on_off_subtext
                    startToStart = PARENT_ID
                    endToStart = R.id.settings_duration_field
                }

                durationSubtext = textView("Duration of delay in seconds") {
                    id = R.id.settings_duration_subtext
                    textAppearance = R.style.TextAppearance_Small
                }.lparams(matchConstraint, wrapContent) {
                    horizontalMargin = dip(16)
                    topToBottom = R.id.settings_duration_text
                    startToStart = PARENT_ID
                    endToStart = R.id.settings_duration_field
                }

                durationField = editText {
                    id = R.id.settings_duration_field
                    textAlignment = EditText.TEXT_ALIGNMENT_CENTER
                    inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL
                }.lparams(dip(80), wrapContent) {
                    horizontalMargin = dip(16)
                    topToTop = R.id.settings_duration_text
                    bottomToBottom = R.id.settings_duration_subtext
                    endToEnd = PARENT_ID
                }

                randomText = textView("Random delay") {
                    id = R.id.settings_random_text
                    textAppearance = R.style.TextAppearance_Medium
                }.lparams(matchConstraint, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(16)
                    topToBottom = R.id.settings_duration_subtext
                    startToStart = PARENT_ID
                    endToStart = R.id.settings_random_switch
                }

                randomSubtext = textView("Random delay will be assigned") {
                    id = R.id.settings_random_subtext
                    textAppearance = R.style.TextAppearance_Small
                }.lparams(matchConstraint, wrapContent) {
                    horizontalMargin = dip(16)
                    topToBottom = R.id.settings_random_text
                    startToStart = PARENT_ID
                    endToStart = R.id.settings_random_switch
                }

                randomSwitch = themedSwitch(R.style.AppTheme_Switch) {
                    id = R.id.settings_random_switch
                }.lparams(dip(80), wrapContent) {
                    margin = dip(16)
                    topToTop = R.id.settings_random_text
                    bottomToBottom = R.id.settings_random_subtext
                    endToEnd = PARENT_ID
                }

            }.lparams(matchParent, wrapContent)
        }
    }

}
