package com.example.imdbsandbox.network.models

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Entity
@Parcelize
data class AggregateRating(
    @SerializedName("@type")val type: String,
    val bestRating: String,
    val ratingCount: Int,
    val ratingValue: Double,
    val worstRating: String
):Parcelable