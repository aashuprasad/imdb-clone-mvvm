package com.example.imdbsandbox.favourite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imdbsandbox.database.moviedatabase.MovieDao
import com.example.imdbsandbox.network.models.Movie


class FavViewModel(private val myDao: MovieDao) : ViewModel() {

    suspend fun getAllData(): List<Movie> {
        return myDao.getFavoriteMovies()
    }
    /*private val myDatabase = MovieDatabase.getInstance()
    private val myDao = myDatabase.movieDao()

    val myData: List<Movie> = myDao.getFavoriteMovies()*/
}

class FavViewModelFactory(
    private val myDao: MovieDao
) : ViewModelProvider.Factory {
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavViewModel::class.java)) {
            return FavViewModel(myDao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}