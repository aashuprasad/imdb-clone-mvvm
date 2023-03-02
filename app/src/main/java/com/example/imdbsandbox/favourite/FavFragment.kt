package com.example.imdbsandbox.favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbsandbox.R
import com.example.imdbsandbox.network.models.Movie
import kotlinx.coroutines.launch


class FavFragment : Fragment() {

    lateinit var abc : List<Movie>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProvider(this).get(FavViewModel::class.java)
        lifecycleScope.launch{
            abc = viewModel.getAllData()
        }

        val recyclerView = view?.findViewById<RecyclerView>(R.id.favMovies)
        recyclerView?.adapter = FavListAdapter(abc)
        return inflater.inflate(R.layout.fragment_fav, container, false)
    }

}