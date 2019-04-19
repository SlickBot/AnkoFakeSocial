package com.ulj.slicky.ankofakesocial.activity.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ulj.slicky.ankofakesocial.activity.content.ContentActivity
import com.ulj.slicky.ankofakesocial.displayAlert
import com.ulj.slicky.ankofakesocial.shake
import com.ulj.slicky.ankofakesocial.string
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.wtf

/**
 * Created by SlickyPC on 18.5.2017
 */
class SignUpFragment : Fragment(), AnkoLogger {

    companion object {
        internal fun newInstance() = SignUpFragment()
    }

    internal lateinit var ui: SignUpFragmentUI

    private var task: SignUpTask? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return SignUpFragmentUI().also { ui = it }.createView(AnkoContext.create(ctx, this))
    }

    override fun onDetach() {
        super.onDetach()
        task?.cancel()
    }

    internal fun trySignup() {
        val validator = SignUpValidator(ui)
        if (validator.validate()) {
            if (validator.acceptedLegalNotice) {
                with(ui) {
                    task = SignUpTask(this@SignUpFragment,
                            firstNameField.string,
                            lastNameField.string,
                            emailField.string,
                            firstPasswordField.string).apply { execute() }
                }
            } else {
                requireActivity().displayAlert("You have to accept legal notice!")
            }
        } else {
            shakeStage()
        }
    }

    internal fun successSignup() {
        requireActivity().startActivity<ContentActivity>()
        requireActivity().finish()
    }

    internal fun failSignup(text: String, e: Exception?) {
        requireActivity().displayAlert(text + if (e != null) "\n" + e.localizedMessage else "")
        shakeStage()
        wtf(text, e)
    }

    private fun shakeStage() {
        with(ui) {
            requireContext().shake(firstNameField, lastNameField, emailField, firstPasswordField, secondPasswordField)
        }
    }

}
