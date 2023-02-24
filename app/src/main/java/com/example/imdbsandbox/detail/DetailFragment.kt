package com.example.imdbsandbox.detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.imdbsandbox.WebActivity
import com.example.imdbsandbox.databinding.FragmentDetailBinding
import com.example.imdbsandbox.listners.DetailOnClickListener

class DetailFragment : Fragment(), DetailOnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val movie = DetailFragmentArgs.fromBundle(requireArguments()).selectedMovie
        val viewModelFactory = DetailViewModelFactory(movie, application)
        binding.viewModel = ViewModelProvider(this, viewModelFactory)
            .get(DetailViewModel::class.java)
        binding.click = this
        return binding.root
    }

    override fun onOpenIMDBCLick(view: View, url: String) {
        println(view)
        val intent = Intent(context, WebActivity::class.java)
        intent.putExtra("URL", url)
        context?.startActivity(intent)
    }
}