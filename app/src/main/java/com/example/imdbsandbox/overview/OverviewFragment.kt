package com.example.imdbsandbox.overview

import android.os.Bundle
import android.text.InputType
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.imdbsandbox.R
import com.example.imdbsandbox.databinding.FragmentOverviewBinding
import com.example.imdbsandbox.network.models.Movie

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }
    private val movielist: ArrayList<Movie> = ArrayList()
    private lateinit var binding: FragmentOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel
        binding.photoGridAction.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener {
                viewModel.displayMovieDetails(it)
            }, movielist
        )
        binding.photoGridAnimation.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener {
                viewModel.displayMovieDetails(it)
            }, movielist
        )
        binding.photoGridComedy.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener {
                viewModel.displayMovieDetails(it)
            }, movielist
        )
        binding.photoGridDrama.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener {
                viewModel.displayMovieDetails(it)
            }, movielist
        )
        binding.photoGridCrime.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener {
                viewModel.displayMovieDetails(it)
            }, movielist
        )
        viewModel.navigateToSelectedMovie.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(OverviewFragmentDirections.actionShowDetails(it))
                viewModel.displayMovieDetailsComplete()
            }
        })

        viewModel.movie.observe(viewLifecycleOwner) {
            movielist.addAll(it)
        }


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.overflow_menu, menu)

        val searchByName = menu.findItem(R.id.my_search)
        val searchNameView = searchByName.actionView as SearchView

        searchNameView.queryHint = "Enter movies name for results.."
        searchNameView.inputType = InputType.TYPE_CLASS_TEXT

        searchNameView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                (binding.photoGridAction.adapter as PhotoGridAdapter).filter.filter(newText)
                (binding.photoGridAnimation.adapter as PhotoGridAdapter).filter.filter(newText)
                (binding.photoGridComedy.adapter as PhotoGridAdapter).filter.filter(newText)
                (binding.photoGridCrime.adapter as PhotoGridAdapter).filter.filter(newText)
                (binding.photoGridDrama.adapter as PhotoGridAdapter).filter.filter(newText)



                return false
            }
        })

        super.onCreateOptionsMenu(menu, inflater)
    }

}