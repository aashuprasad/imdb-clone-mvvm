package com.example.imdbsandbox.overview

import android.os.Bundle
import android.text.InputType
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.imdbsandbox.R
import com.example.imdbsandbox.databinding.FragmentOverviewBinding
import com.example.imdbsandbox.network.models.Movie
import com.google.android.material.floatingactionbutton.FloatingActionButton


class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }
    private val actionMovieList: ArrayList<Movie> = ArrayList()
    private var animationMovieList: ArrayList<Movie> = ArrayList()
    private var comedyMovieList: ArrayList<Movie> = ArrayList()
    private var dramaMovieList: ArrayList<Movie> = ArrayList()
    private var crimeMovieList: ArrayList<Movie> = ArrayList()
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
            }, actionMovieList
        )
        binding.photoGridAnimation.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener {
                viewModel.displayMovieDetails(it)
            }, animationMovieList
        )
        binding.photoGridComedy.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener {
                viewModel.displayMovieDetails(it)
            }, comedyMovieList
        )
        binding.photoGridDrama.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener {
                viewModel.displayMovieDetails(it)
            }, dramaMovieList
        )
        binding.photoGridCrime.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener {
                viewModel.displayMovieDetails(it)
            }, crimeMovieList
        )
        viewModel.navigateToSelectedMovie.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(OverviewFragmentDirections.actionShowDetails(it))
                viewModel.displayMovieDetailsComplete()
            }
        })



        viewModel.movie.observe(viewLifecycleOwner) {
            for (item in it) {
                if (item.genre.contains("Action")) {
                    actionMovieList.add(item)
                }
            }
        }
        viewModel.movie.observe(viewLifecycleOwner) {
            for (item in it) {
                if (item.genre.contains("Animation")) {
                    animationMovieList.add(item)
                }
            }
        }
        viewModel.movie.observe(viewLifecycleOwner) {
            for (item in it) {
                if (item.genre.contains("Comedy")) {
                    comedyMovieList.add(item)
                }
            }
        }
        viewModel.movie.observe(viewLifecycleOwner) {
            for (item in it) {
                if (item.genre.contains("Drama")) {
                    dramaMovieList.add(item)
                }
            }
        }
        viewModel.movie.observe(viewLifecycleOwner) {
            for (item in it) {
                if (item.genre.contains("Crime")) {
                    crimeMovieList.add(item)
                }
            }
        }

        val refreshButton = binding.refreshButton
        val params = refreshButton.layoutParams as CoordinatorLayout.LayoutParams
        params.behavior = FloatingActionButton.Behavior()

        refreshButton.layoutParams = params


        binding.refreshButton.setOnClickListener {
            viewModel.getMovieDetails()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.my_favorite -> {
                val navController: NavController = Navigation.findNavController(
                    requireActivity(),
                    R.id.nav_host_fragment
                )
                navController.navigate(R.id.action_overviewFragment_to_favFragment)

            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
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