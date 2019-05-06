package com.ulj.slicky.ankofakesocial.activity.detail

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.squareup.picasso.Picasso
import com.ulj.slicky.ankofakesocial.*
import com.ulj.slicky.ankofakesocial.activity.BackableActivity
import com.ulj.slicky.ankofakesocial.activity.profile.ProfileActivity
import com.ulj.slicky.ankofakesocial.activity.profile.ProfileActivity.Companion.startFriendProfile
import com.ulj.slicky.ankofakesocial.model.content.Content
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.wtf
import java.util.*


/**
 * Created by SlickyPC on 8.6.2017
 */
class DetailActivity : BackableActivity(), AnkoLogger {

    companion object {
        private val TAG = ProfileActivity::class.java.canonicalName
        private val KEY_CONTENT = "$TAG.contents"

        fun Activity.startDetail(content: Content) {
            startActivity(intentFor<DetailActivity>(KEY_CONTENT to content))
        }
    }

    private lateinit var ui: DetailActivityUI
    private lateinit var content: Content

    private var task: RemoveTask? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = DetailActivityUI().also {
            it.setContentView(this)
        }

        val extras = intent.extras ?: return
        content = extras.getParcelable(KEY_CONTENT) ?: return

        with(content) {
            val imageUrl = owner.picture.large
            val name = owner.fullName()
            val postedAtDate = Date(postedAt).formattedWithTime()

            if (isAppiumTest()) {
                Picasso.with(this@DetailActivity).load(R.drawable.test_img)
                        .placeholder(R.drawable.ic_user)
                        .transform(CropCircleTransformation())
                        .into(ui.ownerImage)
            } else {
                Picasso.with(this@DetailActivity).load(imageUrl)
                        .placeholder(R.drawable.ic_user)
                        .transform(CropCircleTransformation())
                        .into(ui.ownerImage)
            }

            ui.ownerName.text = name
            ui.postedAt.text = "Posted at: $postedAtDate"
            ui.detailText.text = text
        }
    }

    override fun onStop() {
        super.onStop()
        task?.cancel()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.detail_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_remove) {
            displayConfirmationDialog()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun onOpenProfile() {
        startFriendProfile(content.owner)
    }

    internal fun handleError(text: String, e: Exception?) {
        displayAlert(text + if (e != null) "\n" + e.localizedMessage else "")
        wtf(text, e)
    }

    private fun displayConfirmationDialog() {
        displayAlert("Do you really want to remove this Content?") {
            setPositiveButton("Yes") { _, _ -> task = RemoveTask(this@DetailActivity, content).apply { execute() } }
            setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
        }
    }

}
