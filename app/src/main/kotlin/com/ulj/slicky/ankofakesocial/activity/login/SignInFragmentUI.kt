package com.ulj.slicky.ankofakesocial.activity.login

import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.ImageView
import android.widget.ImageView.ScaleType.FIT_CENTER
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.color
import com.ulj.slicky.ankofakesocial.utils.constraintLayout
import com.ulj.slicky.ankofakesocial.utils.matchConstraint
import com.ulj.slicky.ankofakesocial.utils.parentId
import com.ulj.slicky.ankofakesocial.utils.themedTextInputEditText
import org.jetbrains.anko.*
import org.jetbrains.anko.design.themedTextInputLayout
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by root on 7/14/17
 */
internal class SignInFragmentUI : AnkoComponent<SignInFragment> {

    lateinit var logo: ImageView
    lateinit var emailLayout: TextInputLayout
    lateinit var emailField: TextInputEditText
    lateinit var passwordLayout: TextInputLayout
    lateinit var passwordField: TextInputEditText
    lateinit var signinButton: Button
    lateinit var signupButton: Button

    override fun createView(ui: AnkoContext<SignInFragment>) = with(ui) {
        constraintLayout {

            logo = imageView(R.drawable.logo) {
                id = R.id.signin_logo
                scaleType = FIT_CENTER
                contentDescription = "Logo"
            }.lparams(matchConstraint, dip(120)) {
                topMargin = dip(32)
                topToTop = parentId
                startToStart = parentId
                endToEnd = parentId
            }

            emailLayout = themedTextInputLayout(R.style.TextAppearance_App_TextInputLayout) {
                id = R.id.signin_email_layout

                emailField = themedTextInputEditText(R.style.EditText) {
                    id = R.id.signin_email

                    setText("change@me.pls")
                    hint = "Email"
                    inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                    maxLines = 1

                    bottomPadding = dip(16)
                    horizontalPadding = dip(16)
                }
            }.lparams(matchConstraint, wrapContent) {
                topMargin = dip(16)
                horizontalMargin = dip(24)
                topToBottom = R.id.signin_logo
                startToStart = parentId
                endToEnd = parentId
            }

            passwordLayout = themedTextInputLayout(R.style.TextAppearance_App_TextInputLayout) {
                id = R.id.signin_password_layout
                isPasswordVisibilityToggleEnabled = true

                passwordField = themedTextInputEditText(R.style.EditText) {
                    id = R.id.signin_password

                    setText("password")
                    hint = "Password"
                    imeOptions = EditorInfo.IME_ACTION_DONE
//                    inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                    transformationMethod = PasswordTransformationMethod.getInstance()
                    maxLines = 1

                    setOnEditorActionListener { _, actionId, _ ->
                        if (actionId == EditorInfo.IME_ACTION_DONE) {
                            owner.trySignin(); true
                        } else
                            false
                    }

                    bottomPadding = dip(16)
                    horizontalPadding = dip(16)
                }
            }.lparams(matchConstraint, wrapContent) {
                topMargin = dip(16)
                horizontalMargin = dip(24)
                topToBottom = R.id.signin_email_layout
                startToStart = parentId
                endToEnd = parentId
            }

            signinButton = button("Sign In") {
                id = R.id.signin_signin_button
                backgroundResource = R.drawable.button_background_solid
                onClick { owner.trySignin() }
            }.lparams(matchConstraint, dip(48)) {
                topMargin = dip(24)
                horizontalMargin = dip(24)
                topToBottom = R.id.signin_password_layout
                startToStart = parentId
                endToEnd = parentId
            }

            signupButton = button("Sign Up") {
                id = R.id.signin_signup_button
                backgroundResource = R.drawable.button_background_transparent
                onClick { (owner.activity as LoginActivity).onMoveToSignUpClick() }
            }.lparams(matchConstraint, dip(48)) {
                topMargin = dip(24)
                horizontalMargin = dip(24)
                topToBottom = R.id.signin_signin_button
                startToStart = parentId
                endToEnd = parentId
            }

            textView("Forgot your login details?") {
                textColor = ctx.color(R.color.colorTextDark)
                onClick { (owner.activity as LoginActivity).onLostDetailsClick() }
            }.lparams(wrapContent, wrapContent) {
                margin = dip(24)
                topToBottom = R.id.signin_signup_button
                bottomToBottom = parentId
                startToStart = parentId
                endToEnd = parentId
            }
        }
    }
}