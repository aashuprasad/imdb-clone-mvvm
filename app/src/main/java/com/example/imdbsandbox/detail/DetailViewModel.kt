package com.example.imdbsandbox.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.imdbsandbox.network.models.Movie

class DetailViewModel(movieDetail: Movie, app: Application) : AndroidViewModel(app) {

    private val _selectedMovie = MutableLiveData<Movie>()
    val selectedMovie : LiveData<Movie>
        get() = _selectedMovie

    init {
        _selectedMovie.value = movieDetail
    }
}
