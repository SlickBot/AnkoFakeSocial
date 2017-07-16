package com.ulj.slicky.ankofakesocial.activity.creator

import com.ulj.slicky.ankofakesocial.string

/**
 * Created by SlickyPC on 8.6.2017
 */
internal class CreatorValidator(val activity: CreatorActivity) {

    fun validate(): Boolean {
        with(activity.ui) {
            textLayout.error = null

            val text = textLayout.editText.string
            if (text.length < 5) {
                textLayout.error = "Text is too short! (minimum is 5)"
                textLayout.requestFocus()
                return false
            }
            if (text.length > 256) {
                textLayout.error = "Text is too long! (minimum is 256)"
                textLayout.requestFocus()
                return false
            }
        }

        return true
    }
}
