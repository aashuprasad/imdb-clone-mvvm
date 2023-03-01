package com.example.imdbsandbox.network.models

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Entity
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