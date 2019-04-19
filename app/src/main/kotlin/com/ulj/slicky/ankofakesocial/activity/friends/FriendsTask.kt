package com.ulj.slicky.ankofakesocial.activity.friends

import com.ulj.slicky.ankofakesocial.activity.ProgressDialogTask
import com.ulj.slicky.ankofakesocial.db.FakeDBHandler
import com.ulj.slicky.ankofakesocial.model.person.Person
import java.io.IOException
import java.lang.ref.WeakReference

/**
 * Created by SlickyPC on 24.5.2017
 */
internal class FriendsTask(
        activity: FriendsActivity
) : ProgressDialogTask<List<Person>>(activity, "Loading Friends...") {

    private val activityReference = WeakReference(activity)

    @Throws(IOException::class)
    override fun backgroundTask() = FakeDBHandler.getFriends()

    override fun success(result: List<Person>) = activityReference.get()?.setFriends(result)

    override fun fail(e: Exception) = activityReference.get()?.onFail("Could not retrieve Friends!", e)

}
