package com.example.imdbsandbox

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.imdbsandbox.network.models.Movie
import com.example.imdbsandbox.overview.MovieApiStatus
import com.example.imdbsandbox.overview.PhotoGridAdapter


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}

@BindingAdapter("listActionData")
fun bindActionRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
    val actionMovies = data?.filter { it.genre.contains("Action") }
    val adapter: PhotoGridAdapter? = recyclerView.adapter as PhotoGridAdapter?
    adapter?.submitList(actionMovies)
}


@BindingAdapter("listAnimationData")
fun bindAnimationRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
    val animationMovies = data?.filter { it.genre.contains("Animation") }
    val adapter: PhotoGridAdapter? = recyclerView.adapter as PhotoGridAdapter?
    adapter?.submitList(animationMovies)
}

@BindingAdapter("listComedyData")
fun bindComedyRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
    val comedyMovies = data?.filter { it.genre.contains("Comedy") }
    val adapter: PhotoGridAdapter? = recyclerView.adapter as PhotoGridAdapter?
    adapter?.submitList(comedyMovies)
}

@BindingAdapter("listDramaData")
fun bindDramaRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
    val dramaMovies = data?.filter { it.genre.contains("Drama") }
    val adapter: PhotoGridAdapter? = recyclerView.adapter as PhotoGridAdapter?
    adapter?.submitList(dramaMovies)
}

@BindingAdapter("listCrimeData")
fun bindCrimeRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
    val crimeMovies = data?.filter { it.genre.contains("Crime") }
    val adapter: PhotoGridAdapter? = recyclerView.adapter as PhotoGridAdapter?
    adapter?.submitList(crimeMovies)
}

@BindingAdapter("movieRating")
fun bindMovieRating(textView: TextView, movie: Movie) {
    val rating = movie.aggregateRating.ratingValue.toString()
    textView.text = rating
}

@BindingAdapter("movieActors")
fun bindActors(textView: TextView, movie: Movie) {
    var namesOfActor = ""
    val namesoofActor = movie.actor?.map { it.name }
    namesOfActor = namesoofActor!!.joinToString(",")
    textView.text = namesOfActor

}


@BindingAdapter("movieApiStatus")
fun bindStatus(statusImageView: ImageView, status: MovieApiStatus?) {
    if (status == MovieApiStatus.LOADING) {
        statusImageView.visibility = View.VISIBLE
        statusImageView.setImageResource(R.drawable.loading_animation)
    } else if (status == MovieApiStatus.ERROR) {
        statusImageView.visibility = View.VISIBLE
        statusImageView.setImageResource(R.drawable.ic_connection_error)
    } else if (status == MovieApiStatus.DONE) {
        statusImageView.visibility = View.GONE
    }
}