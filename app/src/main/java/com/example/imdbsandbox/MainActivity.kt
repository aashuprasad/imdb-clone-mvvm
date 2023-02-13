package com.example.imdbsandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.imdbsandbox.databinding.ActivityMainBinding
import com.example.imdbsandbox.network.APIService
import com.example.imdbsandbox.network.APIUtilities
import com.example.imdbsandbox.network.MovieAPI
import com.example.imdbsandbox.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val movieApi = APIUtilities.getInstance().create(APIService::class.java)

        lifecycleScope.launch(Dispatchers.IO) {
            val result = movieApi.getData()
            if(result.body() != null){
                Log.d("DATA", "onCreate:${result.body()!!}")
            }
            /*withContext(Dispatchers.Main){
                binding.mainTV.text = viewModel.movies.value.toString()
            }*/
        }


    }
}