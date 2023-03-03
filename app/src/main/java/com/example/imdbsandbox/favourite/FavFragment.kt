package com.example.imdbsandbox.favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbsandbox.R
import com.example.imdbsandbox.database.moviedatabase.MovieDatabase
import com.example.imdbsandbox.network.models.Movie
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class FavFragment : Fragment() {

    lateinit var allMovies : List<Movie>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val movieDatabase = MovieDatabase.getInstance(requireContext())
        val movieDao = movieDatabase.movieDao()
        val viewModel : FavViewModel = ViewModelProvider(this, FavViewModelFactory(movieDao))[FavViewModel::class.java]
        lifecycleScope.launch{
            allMovies = viewModel.getAllData()
            delay(1000)
            val recyclerView = view?.findViewById<RecyclerView>(R.id.favMovies)
            recyclerView?.adapter = FavListAdapter(allMovies)

        }
        return inflater.inflate(R.layout.fragment_fav, container, false)
    }

}