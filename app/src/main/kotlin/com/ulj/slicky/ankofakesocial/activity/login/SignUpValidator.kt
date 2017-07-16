package com.ulj.slicky.ankofakesocial.activity.login

import android.util.Patterns
import android.view.View
import com.ulj.slicky.ankofakesocial.text

/**
 * Created by SlickyPC on 1.6.2017
 */
internal class SignUpValidator(val ui: SignUpFragmentUI) {

    internal val acceptedLegalNotice: Boolean
        get() = ui.legalCheckBox.isChecked

    fun validate(): Boolean {
        with(ui) {
            var errorField: View? = null

            firstNameLayout.error = null
            lastNameLayout.error = null
            emailLayout.error = null
            firstPasswordLayout.error = null
            secondPasswordLayout.error = null

            val first = firstNameLayout.text
            val last = lastNameLayout.text
            val email = emailLayout.text
            val firstPassword = firstPasswordLayout.text
            val secondPassword = secondPasswordLayout.text

            if (first.length < 2) {
                firstNameLayout.error = "First name is too short! (min 2)"
                errorField = firstNameLayout
            } else if (first.length > 50) {
                firstNameLayout.error = "First name is too long! (max 50)"
                errorField = firstNameLayout
            }

            if (last.length < 2) {
                lastNameLayout.error = "Last name is too short! (min 2)"
                if (errorField == null)
                    errorField = lastNameLayout
            } else if (last.length > 50) {
                lastNameLayout.error = "Last name is too long! (max 50)"
                if (errorField == null)
                    errorField = lastNameLayout
            }

            if (email.length < 5) {
                emailLayout.error = "Email is too short! (min 5)"
                if (errorField == null)
                    errorField = emailLayout
            } else if (email.length > 50) {
                emailLayout.error = "Email is too long! (max 50)"
                if (errorField == null)
                    errorField = emailLayout
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailLayout.error = "Email is not valid!"
                if (errorField == null)
                    errorField = emailLayout
            }

            if (firstPassword.length < 8) {
                firstPasswordLayout.error = "Password is too short! (min 8)"
                if (errorField == null)
                    errorField = firstPasswordLayout
            } else if (firstPassword.length > 50) {
                firstPasswordLayout.error = "Password is too long! (max 50)"
                if (errorField == null)
                    errorField = firstPasswordLayout
            } else if (secondPassword != firstPassword) {
                secondPasswordLayout.error = "Passwords do not match!"
                if (errorField == null)
                    errorField = secondPasswordLayout
            }

            if (errorField != null) {
                errorField.requestFocus()
                return false
            }

            return true
        }
    }
}
