package com.example.imdbsandbox.overview

import android.annotation.SuppressLint
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

enum class MovieApiStatus{LOADING, ERROR, DONE}

class OverviewViewModel: ViewModel() {
    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<MovieApiStatus>()

    // The external immutable LiveData for the request status String
    val status: LiveData<MovieApiStatus>
        get() = _status


    private val _movies = MutableLiveData<List<Movie>>()
    val movie:LiveData<List<Movie>> get()=_movies

    val bmovie:LiveData<List<Movie>> get()=_movies

    val cmovie:LiveData<List<Movie>> get()=_movies

    private val _navigateToSelectedMovie = MutableLiveData<Movie?>()
    val navigateToSelectedMovie: MutableLiveData<Movie?>
        get() = _navigateToSelectedMovie


    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMovieDetails()
    }

    private fun getMovieDetails() {
        viewModelScope.launch {
            try{
                _status.value = MovieApiStatus.LOADING
                var listResult = MovieAPI.retrofitService.getMovies()
                _status.value = MovieApiStatus.DONE
                if(listResult.body()!!.isNotEmpty()){
                }
                _movies.value = listResult.body()
                println(_movies.value?.size)
            }catch (e:Exception){
                _status.value = MovieApiStatus.ERROR
                _movies.value = ArrayList()

            }
        }
    }

    fun displayMovieDetails(movie: Movie) {
        _navigateToSelectedMovie.value = movie
    }

    fun displayMovieDetailsComplete() {
        _navigateToSelectedMovie.value = null
    }
}
