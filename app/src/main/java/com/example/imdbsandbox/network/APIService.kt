package com.example.imdbsandbox.network

import com.example.imdbsandbox.network.models.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://raw.githubusercontent.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface APIService {
    @GET("theapache64/top250/master/top250.json")
    suspend fun getMovies(): Response<List<Movie>>
}

object MovieAPI {
    val retrofitService: APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}