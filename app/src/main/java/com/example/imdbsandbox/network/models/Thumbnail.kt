package com.example.imdbsandbox.network.models

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Entity
@Parcelize
data class Thumbnail(
    @SerializedName("@type")val type: String,
    val contentUrl: String
):Parcelable
