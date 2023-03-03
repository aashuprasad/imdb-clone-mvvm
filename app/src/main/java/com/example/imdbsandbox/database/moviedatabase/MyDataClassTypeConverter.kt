package com.example.imdbsandbox.database.moviedatabase

import androidx.room.TypeConverter
import com.example.imdbsandbox.network.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken




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

object MyDataClass2TypeConverter {
    private val gson = Gson()
    @TypeConverter
    fun fromActorList(countryLang: List<Actor?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Actor?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toActorList(countryLangString: String?): List<Actor>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Actor?>?>() {}.type
        return gson.fromJson<List<Actor>>(countryLangString, type)
    }
}

object MyDataClass3TypeConverter {
    private val gson = Gson()

    @TypeConverter
    @JvmStatic
    fun fromString(value: String): AggregateRating {
        return gson.fromJson(value, AggregateRating::class.java)
    }

    @TypeConverter
    @JvmStatic
    fun toString(value: AggregateRating): String {
        return gson.toJson(value)
    }
}

object MyDataClass4TypeConverter {
    private val gson = Gson()
    @TypeConverter
    fun fromCreatorList(countryLang: List<Creator?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Creator?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toCreatorList(countryLangString: String?): List<Creator>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Creator?>?>() {}.type
        return gson.fromJson<List<Creator>>(countryLangString, type)
    }
}

object MyDataClass5TypeConverter {
    private val gson = Gson()
    @TypeConverter
    fun fromDirectorList(countryLang: List<Director?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Director?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toDirectorList(countryLangString: String?): List<Director>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<Director?>?>() {}.type
        return gson.fromJson<List<Director>>(countryLangString, type)
    }
}

object MyDataClass6TypeConverter {
    private val gson = Gson()

    @TypeConverter
    @JvmStatic
    fun fromTrailerString(value: String): Trailer {
        return gson.fromJson(value, Trailer::class.java)
    }

    @TypeConverter
    @JvmStatic
    fun toTrailerString(value: Trailer): String {
        return gson.toJson(value)
    }
}

object MyDataClass7TypeConverter {
    private val gson = Gson()
    @TypeConverter
    fun fromStringList(countryLang: List<String?>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<String?>?>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toStringList(countryLangString: String?): List<String>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson<List<String>>(countryLangString, type)
    }
}
