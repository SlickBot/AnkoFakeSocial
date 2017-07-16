package com.ulj.slicky.ankofakesocial.activity.content

import android.content.res.ColorStateList
import android.os.Build
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.color
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.design.themedAppBarLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4._DrawerLayout
import org.jetbrains.anko.support.v4.drawerLayout

/**
 * Created by root on 7/15/17
 */
internal class ContentActivityUI : AnkoComponent<ContentActivity> {

    lateinit var drawer: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var recycler: RecyclerView

    override fun createView(ui: AnkoContext<ContentActivity>) = with(ui) {
        drawerLayout {
            id = R.id.drawer_layout
            drawer = this
            coordinatorLayout {
                verticalLayout {
                    fitsSystemWindows = true
                    createAppBar(ui)
                    createContentView(ui)
                }.lparams(matchParent, matchParent)
            }.lparams(matchParent, matchParent)

            createNavigationView(ui)
        }
    }

    fun _LinearLayout.createAppBar(ui: AnkoContext<ContentActivity>) {
        themedAppBarLayout(R.style.AppTheme_AppBarOverlay) {
            toolbar = toolbar {
                id = R.id.toolbar
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    popupTheme = R.style.AppTheme_PopupOverlay
                }
                backgroundResource = R.color.colorPrimary
            }.lparams(matchParent, wrapContent)
        }.lparams(matchParent, wrapContent)
    }

    fun _LinearLayout.createContentView(ui: AnkoContext<ContentActivity>) {
        recycler = recyclerView {

        }.lparams(matchParent, matchParent) {
            backgroundResource = R.color.colorBackground
        }
    }

    private fun _DrawerLayout.createNavigationView(ui: AnkoContext<ContentActivity>) {
        navigationView = navigationView {
            backgroundResource = R.color.colorBackground
            itemIconTintList = ColorStateList.valueOf(ui.ctx.color(R.color.colorAccent))

            setNavigationItemSelectedListener(ui.owner)
            inflateMenu(R.menu.content_drawer)

            addHeaderView(context.UI {
                linearLayout {
                    backgroundResource = R.color.colorBackground
                    orientation = LinearLayout.VERTICAL
                    gravity = Gravity.CENTER

                    imageView(R.drawable.logo) {
                        contentDescription = "Logo"
                    }.lparams(wrapContent, dip(80)) {
                        topPadding = dip(16)
                    }

                    textView(R.string.app_name) {
                        setTextAppearance(ctx, R.style.TextAppearance_Large)
                    }.lparams(wrapContent, wrapContent) {
                        topPadding = dip(16)
                    }

                    textView("Where everything is fake") {
                        setTextAppearance(ctx, R.style.TextAppearance_Small)
                        textColor = ctx.color(R.color.colorTextDark)
                    }.lparams(wrapContent, wrapContent)

                }.lparams(matchParent, dimen(R.dimen.nav_header_height)).applyRecursively { view ->
                    when (view) {
                        is TextView -> view.gravity = Gravity.CENTER_HORIZONTAL
                    }
                }
            }.view)
        }.lparams(wrapContent, matchParent, gravity = Gravity.START)
    }
}