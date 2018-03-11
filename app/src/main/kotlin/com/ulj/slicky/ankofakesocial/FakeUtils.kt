@file:Suppress("unused")

package com.ulj.slicky.ankofakesocial

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Vibrator
import android.support.design.widget.TextInputLayout
import android.support.v4.content.ContextCompat
import android.text.format.DateFormat
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.TextView
import com.ulj.slicky.ankofakesocial.model.person.Person
import java.util.*

/**
 * Created by SlickyPC on 24.5.2017
 */
const val SHAKE_DURATION = 300
const val SHAKE_COUNT = 10

fun String.capitalizeAll() = split(" ").joinToString(separator = " ", transform = String::capitalize)

fun Person.fullName() = "${name.first.capitalizeAll()} ${name.last.capitalizeAll()}"

fun Person.fullNameWithTitle() = "${name.title.capitalizeAll()} ${fullName()}"

fun Person.info() = "${location.city.capitalizeAll()}, ${nat.codeToCountry()}"

fun String.codeToCountry(): String = Locale("", this).getDisplayCountry(Locale("en"))

fun Date.formattedWithTime(format: CharSequence = "d. M. yyyy, hh:mm:ss"): CharSequence {
    return DateFormat.format(format, this)
}

fun Date.format(format: CharSequence = "d. M. yyyy"): CharSequence {
    return DateFormat.format(format, this)
}

fun Context.shake(vararg views: View) {
    val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//    if (Build.VERSION.SDK_INT < 26)
    @Suppress("DEPRECATION")
    vibrator.vibrate(SHAKE_DURATION.toLong())
//    else
//        vibrator.vibrate(VibrationEffect.createOneShot(SHAKE_DURATION.toLong(), 1))
    views.forEach { it.shake() }
}

fun View.shake(dur: Int = SHAKE_DURATION, count: Int = SHAKE_COUNT) {
    startAnimation(RotateAnimation(-3f, 3f, (width / 2).toFloat(), (height / 2).toFloat()).apply {
        repeatCount = count
        repeatMode = Animation.REVERSE
        duration = (dur / count).toLong()
    })
}

val TextView?.string: String
    get() = this?.text?.toString() ?: ""

val TextInputLayout.text: String
    get() = editText.string

fun Context.color(id: Int) = ContextCompat.getColor(this, id)

// Context.getDrawable requires min API 21
fun Context.drawable(id: Int): Drawable = ContextCompat.getDrawable(this, id)!!

fun Activity.displayAlert(message: String? = null, op: (AlertDialog.Builder.() -> Unit)? = null) {
    runOnUiThread {
        AlertDialog.Builder(this, R.style.AppTheme_Dialog).apply {
            message?.let { setMessage(it) }
            op?.invoke(this)
        }.show()
    }
}
