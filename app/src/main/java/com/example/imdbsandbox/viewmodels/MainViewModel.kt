package com.example.imdbsandbox.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbsandbox.network.APIService
import com.example.imdbsandbox.network.MovieAPI
import com.example.imdbsandbox.network.models.Movie
import kotlinx.coroutines.launch

enum class MovieAPIStatus{LOADING, ERROR, DONE}

class MainViewModel : ViewModel(){
    private val _status = MutableLiveData<MovieAPIStatus>()
    val status: LiveData<MovieAPIStatus> get() = _status

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    private var movieDataList: ArrayList<Movie> = ArrayList()

    /*init{
        getMovieData()
    }*/


    private fun getMovieData() {
        viewModelScope.launch {
            _status.value = MovieAPIStatus.LOADING
            try {
                _status.value = MovieAPIStatus.DONE
                _movies.value = listOf(MovieAPI.retrofitService.getData().body()!!)
            }catch (e:Exception){
                _status.value = MovieAPIStatus.ERROR
                _movies.value = ArrayList()}
        }
    }
}
