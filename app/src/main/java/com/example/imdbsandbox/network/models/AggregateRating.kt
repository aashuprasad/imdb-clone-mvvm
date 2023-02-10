package com.example.imdbsandbox.network.models

import com.google.gson.annotations.SerializedName

data class AggregateRating(
    @SerializedName("@type")val type: String,
    val bestRating: String,
    val ratingCount: Int,
    val ratingValue: Double,
    val worstRating: String
):java.io.Serializable