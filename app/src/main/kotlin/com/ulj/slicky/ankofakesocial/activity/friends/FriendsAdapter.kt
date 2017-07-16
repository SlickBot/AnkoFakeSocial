package com.ulj.slicky.ankofakesocial.activity.friends

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.ulj.slicky.ankofakesocial.R
import com.ulj.slicky.ankofakesocial.activity.profile.ProfileActivity.Companion.startFriendProfile
import com.ulj.slicky.ankofakesocial.fullName
import com.ulj.slicky.ankofakesocial.info
import com.ulj.slicky.ankofakesocial.model.person.Person
import jp.wasabeef.picasso.transformations.CropCircleTransformation

/**
 * Created by SlickyPC on 24.5.2017
 */
internal class FriendsAdapter(private val activity: FriendsActivity,
                              private val recycler: RecyclerView)
    : RecyclerView.Adapter<FriendsViewHolder>() {

    internal var friends = listOf<Person>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val item = FriendsItemUI(parent)

        item.view.setOnClickListener {
            val itemPosition = recycler.getChildLayoutPosition(item.view)
            val friend = friends[itemPosition]
            activity.startFriendProfile(friend)
        }
        return FriendsViewHolder(item)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        val friend = friends[position]

        with(holder) {
            friendName.text = friend.fullName()
            friendInfo.text = friend.info()

            Picasso.with(activity)
                    .load(friend.picture.medium)
                    .placeholder(R.drawable.ic_user)
                    .transform(CropCircleTransformation())
                    .into(friendImage)
        }
    }

    override fun getItemCount() = friends.size
}
