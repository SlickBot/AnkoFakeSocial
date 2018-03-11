package com.ulj.slicky.ankofakesocial.model.person

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by SlickyPC on 17.5.2017
 */
@Parcelize
data class PersonLocation(val street: String,
                          val city: String,
                          val state: String,
                          val postcode: String) : Parcelable