package com.example.imdbsandbox.network.models

import com.google.gson.annotations.SerializedName

data class Trailer(
    @SerializedName("@type")val type: String,
    val description: String,
    val embedUrl: String,
    val name: String,
    val thumbnail: Thumbnail,
    val thumbnailUrl: String,
    val uploadDate: String
):java.io.Serializable