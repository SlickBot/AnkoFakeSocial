package com.ulj.slicky.ankofakesocial.activity.login

import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
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
internal class SignUpFragmentUI : AnkoComponent<SignUpFragment> {

    lateinit var logo: ImageView
    lateinit var firstNameLayout: TextInputLayout
    lateinit var firstNameField: TextInputEditText
    lateinit var lastNameLayout: TextInputLayout
    lateinit var lastNameField: TextInputEditText
    lateinit var emailLayout: TextInputLayout
    lateinit var emailField: TextInputEditText
    lateinit var firstPasswordLayout: TextInputLayout
    lateinit var firstPasswordField: TextInputEditText
    lateinit var secondPasswordLayout: TextInputLayout
    lateinit var secondPasswordField: TextInputEditText
    lateinit var legalCheckBox: CheckBox
    lateinit var signupButton: Button
    lateinit var signinButton: Button

    override fun createView(ui: AnkoContext<SignUpFragment>) = with(ui) {
        scrollView {
            constraintLayout {

                logo = imageView(R.drawable.logo) {
                    id = R.id.signup_icon
                    contentDescription = "Logo"
                }.lparams(dip(80), dip(80)) {
                    topMargin = dip(24)
                    leftMargin = dip(24)
                    topToTop = parentId
                    startToStart = parentId
                }

                textView("Sign Up") {
                    id = R.id.signup_text
                    textSize = 25f
                }.lparams(matchConstraint, wrapContent) {
                    topMargin = dip(24)
                    leftMargin = dip(12)
                    rightMargin = dip(24)
                    topToTop = parentId
                    bottomToBottom = R.id.signup_icon
                    startToEnd = R.id.signup_icon
                    endToEnd = parentId
                }

                firstNameLayout = themedTextInputLayout(R.style.TextAppearance_App_TextInputLayout) {
                    id = R.id.signup_first_name_layout

                    firstNameField = themedTextInputEditText(R.style.EditText) {
                        id = R.id.signup_first_name
                        bottomPadding = dip(16)
                        horizontalPadding = dip(16)

                        hint = "First name"
                        nextFocusForwardId = R.id.signup_last_name
                        imeOptions = EditorInfo.IME_ACTION_NEXT
                        inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME or InputType.TYPE_TEXT_FLAG_CAP_WORDS
                        maxLines = 1
                    }
                }.lparams(matchConstraint, wrapContent) {
                    topMargin = dip(24)
                    leftMargin = dip(24)
                    rightMargin = dip(6)
                    topToBottom = R.id.signup_icon
                    startToStart = parentId
                    endToStart = R.id.signup_last_name_layout
                }

                lastNameLayout = themedTextInputLayout(R.style.TextAppearance_App_TextInputLayout) {
                    id = R.id.signup_last_name_layout

                    lastNameField = themedTextInputEditText(R.style.EditText) {
                        id = R.id.signup_last_name
                        bottomPadding = dip(16)
                        horizontalPadding = dip(16)

                        hint = "Last name"
                        nextFocusForwardId = R.id.signup_email
                        imeOptions = EditorInfo.IME_ACTION_NEXT
                        inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME or InputType.TYPE_TEXT_FLAG_CAP_WORDS
                        maxLines = 1
                    }
                }.lparams(matchConstraint, wrapContent) {
                    topMargin = dip(24)
                    rightMargin = dip(24)
                    leftMargin = dip(6)
                    topToBottom = R.id.signup_icon
                    startToEnd = R.id.signup_first_name_layout
                    endToEnd = parentId
                }

                emailLayout = themedTextInputLayout(R.style.TextAppearance_App_TextInputLayout) {
                    id = R.id.signup_email_layout
                    isErrorEnabled = true

                    emailField = themedTextInputEditText(R.style.EditText) {
                        id = R.id.signup_email
                        bottomPadding = dip(16)
                        horizontalPadding = dip(16)

                        hint = "Email"
                        nextFocusForwardId = R.id.signup_first_password
                        imeOptions = EditorInfo.IME_ACTION_NEXT
                        inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                        maxLines = 1
                    }
                }.lparams(matchConstraint, wrapContent) {
                    horizontalMargin = dip(24)
                    topToBottom = R.id.signup_last_name_layout
                    startToStart = parentId
                    endToEnd = parentId
                }

                firstPasswordLayout = themedTextInputLayout(R.style.TextAppearance_App_TextInputLayout) {
                    id = R.id.signup_first_password_layout
                    isPasswordVisibilityToggleEnabled = true

                    firstPasswordField = themedTextInputEditText(R.style.EditText) {
                        id = R.id.signup_first_password
                        bottomPadding = dip(16)
                        horizontalPadding = dip(16)

                        hint = "Password"
                        nextFocusForwardId = R.id.signup_second_password
                        imeOptions = EditorInfo.IME_ACTION_NEXT
//                    inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                        transformationMethod = PasswordTransformationMethod.getInstance()
                        maxLines = 1
                    }
                }.lparams(matchConstraint, wrapContent) {
                    horizontalMargin = dip(24)
                    topToBottom = R.id.signup_email_layout
                    startToStart = parentId
                    endToEnd = parentId
                }

                secondPasswordLayout = themedTextInputLayout(R.style.TextAppearance_App_TextInputLayout) {
                    id = R.id.signup_second_password_layout
                    isPasswordVisibilityToggleEnabled = true

                    secondPasswordField = themedTextInputEditText(R.style.EditText) {
                        id = R.id.signup_second_password
                        bottomPadding = dip(16)
                        horizontalPadding = dip(16)

                        hint = "Retype password"
//                    inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                        transformationMethod = PasswordTransformationMethod.getInstance()
                        maxLines = 1

                        setOnEditorActionListener { _, actionId, _ ->
                            if (actionId == EditorInfo.IME_ACTION_DONE) {
                                owner.trySignup(); true
                            } else
                                false
                        }
                    }
                }.lparams(matchConstraint, wrapContent) {
                    horizontalMargin = dip(24)
                    topToBottom = R.id.signup_first_password_layout
                    startToStart = parentId
                    endToEnd = parentId
                }


                legalCheckBox = checkBox("This is legal notice for the most awesome social network ever imagined. Please, proceed with caution.") {
                    id = R.id.signup_legal_checkbox
                    textColor = ctx.color(R.color.colorTextDark)
                }.lparams(matchConstraint, wrapContent) {
                    margin = dip(24)
                    topToBottom = R.id.signup_second_password_layout
                    startToStart = parentId
                    endToEnd = parentId
                }

                signupButton = button("Sign Up") {
                    id = R.id.signup_signup_button
                    backgroundResource = R.drawable.button_background_solid
                    onClick { owner.trySignup() }
                }.lparams(matchConstraint, dip(48)) {
                    topMargin = dip(24)
                    horizontalMargin = dip(24)
                    topToBottom = R.id.signup_legal_checkbox
                    startToStart = parentId
                    endToEnd = parentId
                }

                signinButton = button("Sign In") {
                    id = R.id.signup_signin_button
                    backgroundResource = R.drawable.button_background_transparent
                    onClick { (owner.activity as LoginActivity).onMoveToSignInClick() }
                }.lparams(matchConstraint, dip(48)) {
                    topMargin = dip(16)
                    horizontalMargin = dip(24)
                    topToBottom = R.id.signup_signup_button
                    startToStart = parentId
                    endToEnd = parentId
                }

            }.lparams(matchParent, wrapContent)
        }
    }
}