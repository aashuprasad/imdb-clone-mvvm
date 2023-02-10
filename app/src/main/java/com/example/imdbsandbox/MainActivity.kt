package com.example.imdbsandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imdbsandbox.databinding.ActivityMainBinding
import com.example.imdbsandbox.network.models.Movie

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}