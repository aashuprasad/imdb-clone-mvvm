package com.example.imdbsandbox.network.models

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Entity
@Parcelize
data class Actor(
    @SerializedName("@type")val type: String,
    val name: String,
    val url: String
):Parcelable