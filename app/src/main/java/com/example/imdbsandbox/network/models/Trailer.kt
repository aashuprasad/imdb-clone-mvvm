package com.example.imdbsandbox.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Trailer(
    @SerializedName("@type")val type: String,
    val description: String,
    val embedUrl: String,
    val name: String,
    val thumbnail: Thumbnail,
    val thumbnailUrl: String,
    val uploadDate: String
):Parcelable