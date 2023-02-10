package com.example.imdbsandbox.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIUtility {
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}