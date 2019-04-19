package com.ulj.slicky.ankofakesocial.activity.friends

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.ulj.slicky.ankofakesocial.activity.BackableActivity
import com.ulj.slicky.ankofakesocial.activity.login.LoginActivity
import com.ulj.slicky.ankofakesocial.db.FakeDBHandler
import com.ulj.slicky.ankofakesocial.displayAlert
import com.ulj.slicky.ankofakesocial.model.person.Person
import org.jetbrains.anko.*

/**
 * Created by SlickyPC on 22.5.2017
 */
class FriendsActivity : BackableActivity(), AnkoLogger {

    private lateinit var ui: FriendsActivityUI
    private lateinit var friendsAdapter: FriendsAdapter

    private var friendsTask: FriendsTask? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = FriendsActivityUI().also {
            it.setContentView(this)
        }

        friendsAdapter = FriendsAdapter(this, ui.recycler)
        with (ui.recycler) {
            layoutManager = LinearLayoutManager(ctx)
            adapter = friendsAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        friendsTask = FriendsTask(this).apply { execute() }
    }

    override fun onStop() {
        super.onStop()
        friendsTask?.cancel()
    }

    internal fun setFriends(friends: List<Person>) {
        friendsAdapter.friends = friends
    }

    internal fun onFail(text: String, e: Exception?) {
        displayAlert(text + if (e != null) "\n" + e.localizedMessage else "") {
            setCancelable(false)
            setPositiveButton("Sign Out") { _, _ ->
                logOut()
            }
        }
        wtf(text, e)
    }

    private fun logOut() {
        FakeDBHandler.signout()
        startActivity<LoginActivity>()
        finish()
    }

}
