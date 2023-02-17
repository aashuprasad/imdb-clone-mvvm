package com.example.imdbsandbox.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Creator(
    @SerializedName("@type")val type: String,
    @SerializedName("name") val name: String?,
    val url: String
):Parcelable