package com.ulj.slicky.ankofakesocial.utils

import android.app.Activity
import android.content.Context
import android.support.design.widget.TextInputEditText
import android.view.ViewManager
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.custom.ankoView

/**
 * Created by root on 7/12/17
 */

inline fun ViewManager.textInputEditText(): TextInputEditText = textInputEditText {}
inline fun ViewManager.textInputEditText(init: (@AnkoViewDslMarker TextInputEditText).() -> Unit): TextInputEditText {
    return ankoView(::TextInputEditText, 0, init)
}

inline fun ViewManager.themedTextInputEditText(theme: Int): TextInputEditText = themedTextInputEditText(theme) {}
inline fun ViewManager.themedTextInputEditText(theme: Int, init: (@AnkoViewDslMarker TextInputEditText).() -> Unit): TextInputEditText {
    return ankoView(::TextInputEditText, theme, init)
}

inline fun Context.textInputEditText(): TextInputEditText = textInputEditText {}
inline fun Context.textInputEditText(init: (@AnkoViewDslMarker TextInputEditText).() -> Unit): TextInputEditText {
    return ankoView(::TextInputEditText, 0, init)
}

inline fun Context.themedTextInputEditText(theme: Int ): TextInputEditText = themedTextInputEditText(theme) {}
inline fun Context.themedTextInputEditText(theme: Int, init: (@AnkoViewDslMarker TextInputEditText).() -> Unit): TextInputEditText {
    return ankoView(::TextInputEditText, theme, init)
}

inline fun Activity.textInputEditText(): TextInputEditText = textInputEditText {}
inline fun Activity.textInputEditText(init: (@AnkoViewDslMarker TextInputEditText).() -> Unit): TextInputEditText {
    return ankoView(::TextInputEditText, 0, init)
}

inline fun Activity.themedTextInputEditText(theme: Int): TextInputEditText = themedTextInputEditText(theme) {}
inline fun Activity.themedTextInputEditText(theme: Int, init: (@AnkoViewDslMarker TextInputEditText).() -> Unit): TextInputEditText {
    return ankoView(::TextInputEditText, theme, init)
}
