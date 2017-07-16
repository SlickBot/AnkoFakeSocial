package com.ulj.slicky.ankofakesocial.activity.settings

import android.text.InputType
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.utils.constraintLayout
import com.ulj.slicky.ankofakesocial.utils.matchConstraint
import com.ulj.slicky.ankofakesocial.utils.parentId
import org.jetbrains.anko.*

/**
 * Created by root on 7/14/17
 */
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
                    setTextAppearance(ctx, R.style.TextAppearance_Medium)
                }.lparams(matchConstraint, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(16)
                    topToTop = parentId
                    startToStart = parentId
                    endToStart = R.id.settings_on_off_switch
                }

                onOffSubtext = textView("When turned on, it will start delayed notify service") {
                    id = R.id.settings_on_off_subtext
                    setTextAppearance(ctx, R.style.TextAppearance_Small)
                }.lparams(matchConstraint, wrapContent) {
                    horizontalMargin = dip(16)
                    topToBottom = R.id.settings_on_off_text
                    startToStart = parentId
                    endToStart = R.id.settings_on_off_switch
                }

                onOffSwitch = themedSwitch(R.style.AppTheme_Switch) {
                    id = R.id.settings_on_off_switch
                }.lparams(dip(80), wrapContent) {
                    margin = dip(16)
                    topToTop = R.id.settings_on_off_text
                    bottomToBottom = R.id.settings_on_off_subtext
                    endToEnd = parentId
                }

                durationText = textView("Delay duration") {
                    id = R.id.settings_duration_text
                    setTextAppearance(ctx, R.style.TextAppearance_Medium)
                }.lparams(matchConstraint, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(16)
                    topToBottom = R.id.settings_on_off_subtext
                    startToStart = parentId
                    endToStart = R.id.settings_duration_field
                }

                durationSubtext = textView("Duration of delay in seconds") {
                    id = R.id.settings_duration_subtext
                    setTextAppearance(ctx, R.style.TextAppearance_Small)
                }.lparams(matchConstraint, wrapContent) {
                    horizontalMargin = dip(16)
                    topToBottom = R.id.settings_duration_text
                    startToStart = parentId
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
                    endToEnd = parentId
                }

                randomText = textView("Random delay") {
                    id = R.id.settings_random_text
                    setTextAppearance(ctx, R.style.TextAppearance_Medium)
                }.lparams(matchConstraint, wrapContent) {
                    topMargin = dip(16)
                    horizontalMargin = dip(16)
                    topToBottom = R.id.settings_duration_subtext
                    startToStart = parentId
                    endToStart = R.id.settings_random_switch
                }

                randomSubtext = textView("Random delay will be assigned") {
                    id = R.id.settings_random_subtext
                    setTextAppearance(ctx, R.style.TextAppearance_Small)
                }.lparams(matchConstraint, wrapContent) {
                    horizontalMargin = dip(16)
                    topToBottom = R.id.settings_random_text
                    startToStart = parentId
                    endToStart = R.id.settings_random_switch
                }

                randomSwitch = themedSwitch(R.style.AppTheme_Switch) {
                    id = R.id.settings_random_switch
                }.lparams(dip(80), wrapContent) {
                    margin = dip(16)
                    topToTop = R.id.settings_random_text
                    bottomToBottom = R.id.settings_random_subtext
                    endToEnd = parentId
                }

            }.lparams(matchParent, wrapContent)
        }
    }
}