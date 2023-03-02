package com.example.imdbsandbox.network.models
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Entity
@Parcelize
data class Movie(
    @PrimaryKey(autoGenerate = true)
    var movieId : Int,
    @SerializedName("@context")val context: String,
    @SerializedName("@type")val type: String,
    val actor: List<Actor>? = null,
    val aggregateRating: AggregateRating,
    val contentRating: String,
    val creator: List<Creator>,
    val datePublished: String,
    val description: String,
    val director: List<Director>,
    val duration: String,
    val genre: List<String>,
    @SerializedName("image") val imgSrcUrl: String,
    val keywords: String,
    val name: String,
    val trailer: Trailer,
    val url: String,
    var isFavorite: Boolean = false
) : Parcelable