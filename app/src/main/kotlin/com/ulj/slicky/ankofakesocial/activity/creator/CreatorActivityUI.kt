package com.ulj.slicky.ankofakesocial.activity.creator

import android.support.design.widget.TextInputLayout
import android.text.InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
import android.text.InputType.TYPE_TEXT_FLAG_MULTI_LINE
import android.view.Gravity.START
import android.view.Gravity.TOP
import android.widget.TextView
import com.ulj.slicky.ankofakesocial.R
import org.jetbrains.anko.*
import org.jetbrains.anko.design.themedTextInputEditText
import org.jetbrains.anko.design.themedTextInputLayout
import org.jetbrains.anko.sdk25.coroutines.onClick


/**
 * Created by root on 7/12/17
 */
internal class CreatorActivityUI : AnkoComponent<CreatorActivity> {

    lateinit var textLayout: TextInputLayout
    lateinit var textField: TextView

    override fun createView(ui: AnkoContext<CreatorActivity>) = with(ui) {

        relativeLayout {
            scrollView {

                textLayout = themedTextInputLayout(R.style.TextInputLayout) {
                    id = R.id.creator_text_layout
                    hint = "Enter new Content here!"
                    counterMaxLength = 256
                    isCounterEnabled = true

                    textField = themedTextInputEditText(R.style.EditText) {
                        id = R.id.creator_text
                        gravity = TOP or START
                        inputType = TYPE_TEXT_FLAG_MULTI_LINE or TYPE_TEXT_FLAG_CAP_SENTENCES
                        minLines = 5

                        setPadding(dip(8), dip(16), dip(8), 0)
                    }
                }.lparams(matchParent, wrapContent) {
                    padding = dip(16)
                    margin = dip(16)
                }

            }.lparams(matchParent, matchParent) {
                above(R.id.creator_button)
            }

            button("Create") {
                id = R.id.creator_button
                backgroundResource = R.drawable.button_background_solid
                onClick { owner.onNewContent() }
            }.lparams(matchParent, wrapContent) {
                margin = dip(16)
                alignParentBottom()
            }
        }
    }
}