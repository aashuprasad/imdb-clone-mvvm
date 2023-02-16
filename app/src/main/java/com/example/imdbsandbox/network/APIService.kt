package com.example.imdbsandbox.network

import com.example.imdbsandbox.network.models.Movie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


const val BASE_URL = "https://raw.githubusercontent.com/"

interface APIService {
    @GET("theapache64/top250/master/top250.json")
    suspend fun getMovies(): Response<List<Movie>>
}

object MovieAPI {
    var interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
    val client = OkHttpClient.Builder().apply {
        addInterceptor(interceptor)
        readTimeout(1, TimeUnit.MINUTES)
        writeTimeout(1,TimeUnit.MINUTES)
    }.build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    val retrofitService: APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}