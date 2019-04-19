package com.ulj.slicky.ankofakesocial.activity.login

import android.annotation.SuppressLint
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
class SignInFragment : Fragment(), AnkoLogger {

    companion object {
        internal fun newInstance() = SignInFragment()
    }

    internal lateinit var ui: SignInFragmentUI

    private var task: SignInTask? = null

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return SignInFragmentUI().also { ui = it }.createView(AnkoContext.create(ctx, this))
    }

    override fun onDetach() {
        super.onDetach()
        task?.cancel()
    }

    internal fun trySignin() {
        val validator = SignInValidator(ui)
        if (validator.validate())
            with(ui) {
                task = SignInTask(this@SignInFragment,
                        emailField.string,
                        passwordField.string).apply { execute() }
            }
        else
            shakeStage()
    }

    internal fun successSignin() {
        requireActivity().startActivity<ContentActivity>()
        requireActivity().finish()
    }

    internal fun failSignin(text: String, e: Exception?) {
        requireActivity().displayAlert(text + if (e != null) "\n" + e.localizedMessage else "")
        shakeStage()
        wtf(text, e)
    }

    private fun shakeStage() = with(ui) { requireContext().shake(emailField, passwordField) }

}
