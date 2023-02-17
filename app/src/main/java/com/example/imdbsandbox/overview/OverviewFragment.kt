package com.example.imdbsandbox.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.imdbsandbox.R
import com.example.imdbsandbox.databinding.FragmentOverviewBinding
import com.example.imdbsandbox.databinding.GridViewItemBinding

class OverviewFragment : Fragment() {

    /**
     * Lazily initialize our [OverviewViewModel].
     */
    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        binding.photoGridAction.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener{
                findNavController().navigate(R.id.detailFragment)
                viewModel.displayMovieDetails(it)
            }
        )
        binding.photoGridAnimation.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener{
                viewModel.displayMovieDetails(it)
            }
        )
        binding.photoGridComedy.adapter = PhotoGridAdapter(
            PhotoGridAdapter.OnClickListener{
                viewModel.displayMovieDetails(it)
            }
        )

        viewModel.navigateToSelectedMovie.observe(viewLifecycleOwner, Observer {
            if(null != it){
                this.findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
                viewModel.displayMovieDetailsComplete()
            }
        })



        return binding.root
    }

}