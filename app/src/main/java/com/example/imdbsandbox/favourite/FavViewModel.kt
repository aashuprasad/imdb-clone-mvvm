package com.example.imdbsandbox.favourite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.imdbsandbox.database.moviedatabase.MovieDao
import com.example.imdbsandbox.database.moviedatabase.MovieDatabase
import com.example.imdbsandbox.network.models.Movie


class FavViewModel(private val myDao:MovieDao) : ViewModel() {

    suspend fun getAllData(): List<Movie> {
        return myDao.getFavoriteMovies()
    }
    /*private val myDatabase = MovieDatabase.getInstance()
    private val myDao = myDatabase.movieDao()

    val myData: List<Movie> = myDao.getFavoriteMovies()*/
}