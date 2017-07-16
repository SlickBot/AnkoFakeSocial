package com.ulj.slicky.ankofakesocial.activity.settings

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.ulj.slicky.ankofakesocial.FakePreferences
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.activity.BackableActivity
import com.ulj.slicky.ankofakesocial.activity.service.NotifyingService
import com.ulj.slicky.ankofakesocial.color
import com.ulj.slicky.ankofakesocial.string
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startService

/**
 * Created by SlickyPC on 22.5.2017
 */
class SettingsActivity : BackableActivity() {

    private lateinit var ui: SettingsActivityUI
    private lateinit var prefs: FakePreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = SettingsActivityUI().also {
            it.setContentView(this)
        }

        prefs = FakePreferences(this).apply {
            ui.onOffSwitch.setOnCheckedChangeListener { _, isChecked ->
                isNotifyOn = isChecked
                updateFields()
                if (isChecked)
                    startService<NotifyingService>()
            }

            ui.durationField.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    notifyDuration = ui.durationField.string.toInt()
                    updateFields()
                }
                return@setOnEditorActionListener false
            }

            ui.randomSwitch.setOnCheckedChangeListener { _, isChecked ->
                isNotifyRandom = isChecked
                updateFields()
            }
        }

        updateFields()
    }

    private fun updateFields() {
        with(ui) {
            with(prefs) {
                onOffSwitch.isChecked = isNotifyOn
                durationField.setText(notifyDuration.toString())
                randomSwitch.isChecked = isNotifyRandom

                val colorId = if (isNotifyRandom) R.color.colorTextDark else R.color.colorText
                val color = color(colorId)

                durationText.setTextColor(color)
                durationField.setTextColor(color)
                durationField.isEnabled = !isNotifyRandom
            }
        }
    }
}
