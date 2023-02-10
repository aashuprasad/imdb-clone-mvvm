package com.example.imdbsandbox.viewmodels

import androidx.lifecycle.ViewModel
import com.example.imdbsandbox.network.APIService
import com.example.imdbsandbox.network.APIUtility
import com.example.imdbsandbox.network.models.Movie

enum class MovieAPIStatus{LOADING, ERROR, DONE}

class MainViewModel : ViewModel(){
    val movieAPI = APIUtility.getInstance().create(APIService::class.java)

    private var movieDataList: ArrayList<Movie> = ArrayList()


    private fun getMovieData() {
        /*viewModelScope.launch {
            _status.value = MovieAPIStatus.LOADING
            try {
                _status.value = MovieAPIStatus.DONE
                _properties.value = MarsApi.retrofitService.()
            }catch (e:Exception){
                _status.value = MarsApiStatus.ERROR
                _properties.value = ArrayList()}
        }*/
    }
}
