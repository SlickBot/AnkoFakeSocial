@file:Suppress("ClassName", "NOTHING_TO_INLINE", "unused")

package com.ulj.slicky.ankofakesocial.utils

import android.app.Activity
import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.FrameLayout
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.custom.ankoView

/**
 * Created by root on 7/13/17
 */
open class _CardView(ctx: Context) : CardView(ctx) {

    var cardBackgroundColorList
        set(value) = setCardBackgroundColor(value)
        get() = cardBackgroundColor

    inline fun <T : View> T.lparams(
            c: Context?,
            attrs: AttributeSet?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(c!!, attrs!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T : View> T.lparams(
            c: Context?,
            attrs: AttributeSet?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(c!!, attrs!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T : View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T : View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T : View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height, gravity)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T : View> T.lparams(
            width: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            height: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
            gravity: Int
    ): T {
        val layoutParams = FrameLayout.LayoutParams(width, height, gravity)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T : View> T.lparams(
            source: ViewGroup.LayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T : View> T.lparams(
            source: ViewGroup.LayoutParams?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T : View> T.lparams(
            source: ViewGroup.MarginLayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T : View> T.lparams(
            source: ViewGroup.MarginLayoutParams?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T : View> T.lparams(
            source: FrameLayout.LayoutParams?,
            init: FrameLayout.LayoutParams.() -> Unit
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        layoutParams.init()
        this@lparams.layoutParams = layoutParams
        return this
    }

    inline fun <T : View> T.lparams(
            source: FrameLayout.LayoutParams?
    ): T {
        val layoutParams = FrameLayout.LayoutParams(source!!)
        this@lparams.layoutParams = layoutParams
        return this
    }

}

inline fun ViewManager.cardView(): _CardView = cardView {}
inline fun ViewManager.cardView(init: (@AnkoViewDslMarker _CardView).() -> Unit): _CardView {
    return ankoView(::_CardView, theme = 0) { init() }
}

inline fun ViewManager.themedCardView(theme: Int = 0): _CardView = themedCardView(theme) {}
inline fun ViewManager.themedCardView(theme: Int = 0, init: (@AnkoViewDslMarker _CardView).() -> Unit): _CardView {
    return ankoView(::_CardView, theme) { init() }
}

inline fun Context.cardView(): _CardView = cardView {}
inline fun Context.cardView(init: (@AnkoViewDslMarker _CardView).() -> Unit): _CardView {
    return ankoView(::_CardView, theme = 0) { init() }
}

inline fun Context.themedCardView(theme: Int = 0): _CardView = themedCardView(theme) {}
inline fun Context.themedCardView(theme: Int = 0, init: (@AnkoViewDslMarker _CardView).() -> Unit): _CardView {
    return ankoView(::_CardView, theme) { init() }
}

inline fun Activity.cardView(): _CardView = cardView {}
inline fun Activity.cardView(init: (@AnkoViewDslMarker _CardView).() -> Unit): _CardView {
    return ankoView(::_CardView, theme = 0) { init() }
}