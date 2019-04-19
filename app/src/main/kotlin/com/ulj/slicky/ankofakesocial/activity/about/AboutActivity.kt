package com.ulj.slicky.ankofakesocial.activity.about

import android.os.Bundle
import com.ulj.slicky.ankofakesocial.activity.BackableActivity
import com.ulj.slicky.ankofakesocial.rest.ApiServices
import org.jetbrains.anko.browse
import org.jetbrains.anko.setContentView

/**
 * Created by SlickyPC on 22.5.2017
 */
class AboutActivity : BackableActivity() {

    private lateinit var ui: AboutActivityUI

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = AboutActivityUI().also {
            it.setContentView(this)
        }
    }

    fun onRandomUserClick() {
        browse(ApiServices.PERSON_URL)
    }

    fun onWatchOutClick() {
        browse(ApiServices.CONTENT_URL)
    }

}
