package com.example.imdbsandbox.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbsandbox.network.MovieAPI
import com.example.imdbsandbox.network.models.Movie
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewViewModel: ViewModel() {
    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val status: LiveData<String>
        get() = _status


    private val _movie = MutableLiveData<Movie>()
    val movie:LiveData<Movie> get()=_movie

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
        viewModelScope.launch {
            try{
                var listResult = MovieAPI.retrofitService.getMovies()
                _status.value = "Success: ${listResult.body()!!.size} Movies retrieved"
                if(listResult.body()!!.isNotEmpty()){
                    _movie.value = listResult.body()?.first()
                }
            }catch (e:Exception){
                _status.value = "Failure: ${e.message}"

            }
        }
    }

}
