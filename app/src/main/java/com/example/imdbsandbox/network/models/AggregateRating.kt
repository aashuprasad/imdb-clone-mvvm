package com.example.imdbsandbox.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AggregateRating(
    @SerializedName("@type")val type: String,
    val bestRating: String,
    val ratingCount: Int,
    val ratingValue: Double,
    val worstRating: String
):Parcelable