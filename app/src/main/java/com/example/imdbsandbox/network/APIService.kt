package com.example.imdbsandbox.network

import com.example.imdbsandbox.network.models.Movie
import retrofit2.Response
import retrofit2.http.GET

const val BASE_URL = "https://raw.githubusercontent.com/"

interface APIService{
    @GET("/theapache64/top250/master/top250.json")
    suspend fun getData(): Response<Movie>
}