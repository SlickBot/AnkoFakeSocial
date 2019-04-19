package com.ulj.slicky.ankofakesocial.activity.content

import com.ulj.slicky.ankofakesocial.activity.ProgressDialogTask
import com.ulj.slicky.ankofakesocial.db.FakeDBHandler
import com.ulj.slicky.ankofakesocial.model.content.Content
import java.io.IOException
import java.lang.ref.WeakReference

/**
 * Created by SlickyPC on 21.5.2017
 */
internal class ContentTask(
        activity: ContentActivity
) : ProgressDialogTask<List<Content>>(activity, "Loading Content...") {

    private val activityReference = WeakReference(activity)

    @Throws(IOException::class)
    override fun backgroundTask() = FakeDBHandler.getContent()

    override fun success(result: List<Content>) = activityReference.get()?.setContent(result)

    override fun fail(e: Exception) = activityReference.get()?.handleError("Could not retrieve Content!", e)

}
