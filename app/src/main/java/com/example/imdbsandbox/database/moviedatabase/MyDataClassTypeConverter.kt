package com.example.imdbsandbox.database.moviedatabase

import androidx.room.TypeConverter
import com.example.imdbsandbox.network.models.Movie
import com.google.gson.Gson

object MyDataClassTypeConverter {
    private val gson = Gson()

    @TypeConverter
    @JvmStatic
    fun fromString(value: String): Movie {
        return gson.fromJson(value, Movie::class.java)
    }

    @TypeConverter
    @JvmStatic
    fun toString(value: Movie): String {
        return gson.toJson(value)
    }
}
