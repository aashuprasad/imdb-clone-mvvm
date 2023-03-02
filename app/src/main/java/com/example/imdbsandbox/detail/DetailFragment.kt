package com.example.imdbsandbox.detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.imdbsandbox.activities.WebActivity
import com.example.imdbsandbox.database.moviedatabase.MovieDao
import com.example.imdbsandbox.database.moviedatabase.MovieDatabase
import com.example.imdbsandbox.databinding.FragmentDetailBinding
import com.example.imdbsandbox.listeners.DetailOnClickListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailFragment : Fragment(), DetailOnClickListener {

    private lateinit var movieDao: MovieDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar?.hide()

        binding.lifecycleOwner = this

        val movieDatabase = MovieDatabase.getInstance(requireContext())
        movieDao = movieDatabase.movieDao()
        val movie = DetailFragmentArgs.fromBundle(requireArguments()).selectedMovie
        val viewModelFactory = DetailViewModelFactory(movie, application)
        binding.viewModel =
            ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        binding.cbHeart.setOnCheckedChangeListener { checkBox, isChecked ->

            if (isChecked) {
                movie.isFavorite = !movie.isFavorite
                GlobalScope.launch {
                    movieDao.insert(movie)
                }
                Toast.makeText(requireContext(), "Item added to Favourite", Toast.LENGTH_SHORT)
                    .show()
            } else {
                movie.isFavorite = !movie.isFavorite
                GlobalScope.launch {
                    movieDao.delete(movie)
                }
                Toast.makeText(requireContext(), "Item removed from Favourite", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.click = this


        return binding.root

    }


    override fun onOpenIMDBCLick(view: View, url: String) {
        println(view)
        val intent = Intent(context, WebActivity::class.java)
        intent.putExtra("URL", url)
        context?.startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as AppCompatActivity).supportActionBar?.show()

    }
}