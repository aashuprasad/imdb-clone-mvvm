package com.example.imdbsandbox.network.models

import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("@type")val type: String,
    val contentUrl: String
):java.io.Serializable
