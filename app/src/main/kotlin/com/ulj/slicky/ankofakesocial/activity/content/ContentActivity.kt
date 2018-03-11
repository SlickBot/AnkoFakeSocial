package com.ulj.slicky.ankofakesocial.activity.content

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.activity.ProgressDialogTask
import com.ulj.slicky.ankofakesocial.activity.about.AboutActivity
import com.ulj.slicky.ankofakesocial.activity.creator.CreatorActivity
import com.ulj.slicky.ankofakesocial.activity.friends.FriendsActivity
import com.ulj.slicky.ankofakesocial.activity.login.LoginActivity
import com.ulj.slicky.ankofakesocial.activity.settings.SettingsActivity
import com.ulj.slicky.ankofakesocial.db.FakeDBHandler
import com.ulj.slicky.ankofakesocial.displayAlert
import com.ulj.slicky.ankofakesocial.model.content.Content
import org.jetbrains.anko.*


class ContentActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, AnkoLogger {

    private lateinit var ui: ContentActivityUI
    private lateinit var contentAdapter: ContentAdapter

    private var contentTask: ContentTask? = null
    private var userTask: ProgressDialogTask<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (!FakeDBHandler.isSignedIn)
            signOut()

        super.onCreate(savedInstanceState)
        ui = ContentActivityUI().also {
            it.setContentView(this)
        }
        setSupportActionBar(ui.toolbar)

        // Thanks Lollipop -> https://stackoverflow.com/a/29455956/6814029
        title = "Content"

        ui.navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, ui.drawer, ui.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        ui.drawer.addDrawerListener(toggle)
        toggle.syncState()

        contentAdapter = ContentAdapter(this, ui.recycler)
        ui.recycler.layoutManager = LinearLayoutManager(this)
        ui.recycler.adapter = contentAdapter
    }

    override fun onStart() {
        super.onStart()
        contentTask = ContentTask(this).apply { execute() }
    }

    override fun onStop() {
        super.onStop()
        contentTask?.cancel()
        userTask?.cancel()
    }

    override fun onBackPressed() {
        if (ui.drawer.isDrawerOpen(GravityCompat.START)) {
            ui.drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> userTask = UserTask(this).apply { execute() }
            R.id.nav_friends -> startActivity<FriendsActivity>()
            R.id.nav_settings -> startActivity<SettingsActivity>()
            R.id.nav_about -> startActivity<AboutActivity>()
            R.id.nav_share -> share("Fakest Social Network!", "This app is really FAKE!")
            R.id.nav_logout -> signOut()
        }

        ui.drawer.closeDrawers()
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.content_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_create) {
            startActivity<CreatorActivity>()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    internal fun setContent(contents: List<Content>) {
        contentAdapter.contents = contents
    }

    private fun signOut() {
        startActivity<LoginActivity>()
        FakeDBHandler.signout()
        finish()
    }

    internal fun handleError(text: String, e: Exception?) {
        displayAlert(text + if (e != null) "\n" + e.localizedMessage else "") {
            setCancelable(false)
            setPositiveButton("Sign Out", { _, _ -> signOut() })
        }
        wtf(text, e)
    }
}
