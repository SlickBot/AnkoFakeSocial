package com.ulj.slicky.ankofakesocial.activity.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

/**
 * Created by SlickyPC on 17.5.2017
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var ui: LoginActivityUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = LoginActivityUI().also {
            it.setContentView(this)
        }

        val adapter = LoginAdapter(supportFragmentManager)
        ui.viewPager.adapter = adapter
        ui.indicator.setViewPager(ui.viewPager)
    }

    override fun onBackPressed() {
        if (ui.viewPager.currentItem > 0)
            ui.viewPager.currentItem = 0
        else
            super.onBackPressed()
    }

    fun onMoveToSignUpClick() {
        ui.viewPager.currentItem = 1
    }

    fun onMoveToSignInClick() {
        ui.viewPager.currentItem = 0
    }

    fun onLostDetailsClick() {
        toast("Well, that sucks.")
    }
}
