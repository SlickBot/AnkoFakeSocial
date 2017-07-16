package com.ulj.slicky.ankofakesocial.utils

import android.view.ViewGroup
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

/**
 * Created by root on 7/13/17
 */
abstract class ChildComponent(val parent: ViewGroup) : AnkoComponent<ViewGroup> {
    val view by lazy { createView(AnkoContext.Companion.create(parent.context, parent)) }
}