package com.example.imdbsandbox.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imdbsandbox.network.MovieAPI
import com.example.imdbsandbox.network.models.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel: ViewModel() {
    // The internal MutableLiveData String that stores the status of the most recent request
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val response: LiveData<String>
        get() = _response

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMovieDetails()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMovieDetails() {
        MovieAPI.retrofitService.getMovies().enqueue(object : Callback<List<Movie>>{
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                _response.value = "success: ${response.body()?.size} Movies retrieved"
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                _response.value = "Failure "+t.message
            }

        })
        _response.value = "Set the Mars API Response here!"
    }
}
