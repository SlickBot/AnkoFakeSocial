@file:Suppress("ClassName", "NOTHING_TO_INLINE", "unused")

package com.ulj.slicky.ankofakesocial.utils

import android.app.Activity
import android.content.Context
import android.view.ViewManager
import com.rd.PageIndicatorView
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.custom.ankoView

/**
 * Created by root on 7/14/17
 */
inline fun ViewManager.pageIndicatorView(): PageIndicatorView = pageIndicatorView {}
inline fun ViewManager.pageIndicatorView(init: (@AnkoViewDslMarker PageIndicatorView).() -> Unit): PageIndicatorView {
    return ankoView(::PageIndicatorView, 0, init)
}

inline fun ViewManager.themedPageIndicatorView(theme: Int): PageIndicatorView = themedPageIndicatorView(theme) {}
inline fun ViewManager.themedPageIndicatorView(theme: Int, init: (@AnkoViewDslMarker PageIndicatorView).() -> Unit): PageIndicatorView {
    return ankoView(::PageIndicatorView, theme, init)
}

inline fun Context.pageIndicatorView(): PageIndicatorView = pageIndicatorView {}
inline fun Context.pageIndicatorView(init: (@AnkoViewDslMarker PageIndicatorView).() -> Unit): PageIndicatorView {
    return ankoView(::PageIndicatorView, 0, init)
}

inline fun Context.themedPageIndicatorView(theme: Int ): PageIndicatorView = themedPageIndicatorView(theme) {}
inline fun Context.themedPageIndicatorView(theme: Int, init: (@AnkoViewDslMarker PageIndicatorView).() -> Unit): PageIndicatorView {
    return ankoView(::PageIndicatorView, theme, init)
}

inline fun Activity.pageIndicatorView(): PageIndicatorView = pageIndicatorView {}
inline fun Activity.pageIndicatorView(init: (@AnkoViewDslMarker PageIndicatorView).() -> Unit): PageIndicatorView {
    return ankoView(::PageIndicatorView, 0, init)
}

inline fun Activity.themedPageIndicatorView(theme: Int): PageIndicatorView = themedPageIndicatorView(theme) {}
inline fun Activity.themedPageIndicatorView(theme: Int, init: (@AnkoViewDslMarker PageIndicatorView).() -> Unit): PageIndicatorView {
    return ankoView(::PageIndicatorView, theme, init)
}
