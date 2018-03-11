package com.ulj.slicky.ankofakesocial.model.person

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by SlickyPC on 17.5.2017
 */
@Parcelize
data class PersonID(val name: String,
                    val value: String?) : Parcelable
