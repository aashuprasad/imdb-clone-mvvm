package com.example.imdbsandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.imdbsandbox.databinding.ActivityMainBinding
import com.example.imdbsandbox.network.APIService
import com.example.imdbsandbox.network.APIUtility
import com.example.imdbsandbox.network.models.Movie
import com.example.imdbsandbox.viewmodels.MainViewModel
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}