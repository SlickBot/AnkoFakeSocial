@file:Suppress("DEPRECATION")

package com.ulj.slicky.ankofakesocial.activity

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.support.v4.content.ContextCompat
import com.ulj.slicky.ankofakesocial.R
import java.io.IOException

/**
 * Created by SlickyPC on 21.5.2017
 */
abstract class ProgressDialogTask<T>(context: Context, message: String) : AsyncTask<Void, Void, T>() {

    private val progress = ProgressDialog(context, R.style.AppTheme_Dialog).apply {
        val logo = ContextCompat.getDrawable(context, R.drawable.loading_drawable)
        setMessage(message)
        isIndeterminate = true
        setIndeterminateDrawable(logo)
        setCancelable(false)
    }

    override fun onPreExecute() {
        progress.show()
    }

    override fun doInBackground(vararg voids: Void): T? {
        return try {
            backgroundTask()
        } catch (e: Exception) {
            if (!isCancelled) {
                fail(e)
                cancel(true)
            }
            null
        }
    }

    override fun onPostExecute(result: T) {
        progress.dismiss()
        success(result)
    }

    override fun onCancelled() {
        progress.dismiss()
    }

    fun cancel() {
        progress.dismiss()
        cancel(true)
    }

    @Throws(IOException::class)
    abstract fun backgroundTask(): T

    abstract fun success(result: T) : Unit?

    abstract fun fail(e: Exception) : Unit?

}
