package com.ulj.slicky.ankofakesocial.activity.creator

import android.os.Bundle
import com.ulj.slicky.ankofakesocial.activity.BackableActivity
import com.ulj.slicky.ankofakesocial.displayAlert
import com.ulj.slicky.ankofakesocial.string
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.wtf


/**
 * Created by SlickyPC on 30.5.2017
 */
class CreatorActivity : BackableActivity(), AnkoLogger {

    internal lateinit var ui: CreatorActivityUI
    private var task: CreatorTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = CreatorActivityUI().also {
            it.setContentView(this)
        }
    }

    override fun onStop() {
        super.onStop()
        task?.cancel()
    }

    fun onNewContent() {
        val validator = CreatorValidator(this)
        if (validator.validate())
            task = CreatorTask(this, ui.textField.string).apply { execute() }
    }

    internal fun onCreatingSuccess() {
        displayAlert("Successfully uploaded new Content!") {
            setCancelable(false)
            setPositiveButton("Cool!", { _, _ -> finish() })
        }
    }

    internal fun onCreatingFail(text: String, e: Exception? = null) {
        displayAlert(text + if (e != null) "\n" + e.localizedMessage else "")
        wtf(text, e)
    }
}
