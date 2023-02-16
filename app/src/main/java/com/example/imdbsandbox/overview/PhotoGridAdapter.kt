package com.example.imdbsandbox.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbsandbox.databinding.GridViewItemBinding
import com.example.imdbsandbox.network.models.Movie

open class PhotoGridAdapter(val onClickListener:OnClickListener) : ListAdapter<Movie, PhotoGridAdapter.MovieViewHolder>(DiffCallback){
    class MovieViewHolder(private var binding:GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie){
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapter.MovieViewHolder {
        return MovieViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.itemView.setOnClickListener {

            onClickListener.onClick(movie)
        }

        holder.bind(movie)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }

    class OnClickListener(val clickListener: (movie:Movie)->Unit){
        fun onClick(movie: Movie) = clickListener(movie)
    }
}