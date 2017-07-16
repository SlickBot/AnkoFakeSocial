package com.ulj.slicky.ankofakesocial.activity.profile

import android.app.Activity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.ulj.slicky.ankofakesocial.*
import com.ulj.slicky.ankofakesocial.activity.BackableActivity
import com.ulj.slicky.ankofakesocial.model.person.Person
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView

/**
 * Created by SlickyPC on 22.5.2017
 */
class ProfileActivity : BackableActivity() {

    companion object {
        private val TAG = ProfileActivity::class.java.canonicalName
        private val KEY_PERSON = TAG + ".person"
        private val KEY_OWNER = TAG + ".owner"

        fun Activity.startOwnerProfile(owner: Person) {
            startActivity(intentFor<ProfileActivity>(KEY_PERSON to owner, KEY_OWNER to true))
        }

        fun Activity.startFriendProfile(friend: Person) {
            startActivity(intentFor<ProfileActivity>(KEY_PERSON to friend, KEY_OWNER to false))
        }
    }

    private lateinit var ui: ProfileActivityUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = ProfileActivityUI().also {
            it.setContentView(this)
        }

        val extras = intent.extras
        val person = extras.getParcelable<Person>(KEY_PERSON)
        val isOwner = extras.getBoolean(KEY_OWNER)

        title = if (isOwner) "Your Profile" else person.fullName()

        with(person) {
            Picasso.with(this@ProfileActivity)
                    .load(picture.large)
                    .placeholder(R.drawable.ic_user)
                    .transform(CropCircleTransformation())
                    .into(ui.icon)

            ui.name.text = fullNameWithTitle()
            ui.email.text = email
            ui.cell.text = cell
            ui.phone.text = phone
            ui.birthday.text = dob.formattedWithTime()
            ui.registered.text = registered.formattedWithTime()
            ui.nat.text = nat.codeToCountry()

            with(location) {
                ui.street.text = street.capitalizeAll()
                ui.city.text = city.capitalizeAll()
                ui.state.text = state.capitalizeAll()
            }
        }

    }
}
