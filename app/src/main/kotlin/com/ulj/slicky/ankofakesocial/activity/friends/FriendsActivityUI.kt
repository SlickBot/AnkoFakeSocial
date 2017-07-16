package com.ulj.slicky.ankofakesocial.activity.friends

import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by root on 7/13/17
 */
internal class FriendsActivityUI : AnkoComponent<FriendsActivity> {

    lateinit var recycler: RecyclerView

    override fun createView(ui: AnkoContext<FriendsActivity>) = with(ui) {
        recyclerView {
            recycler = this
        }
    }
}