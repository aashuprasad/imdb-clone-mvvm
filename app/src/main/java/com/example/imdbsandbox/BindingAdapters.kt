package com.example.imdbsandbox

import android.R.attr.path
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.imdbsandbox.network.models.Movie
import com.example.imdbsandbox.overview.MovieApiStatus
import com.example.imdbsandbox.overview.PhotoGridAdapter


@BindingAdapter("imageUrl")
fun bindImage(imgView:ImageView, imgUrl:String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image))
            .into(imgView)


    }
}

@BindingAdapter("listActionData")
fun bindRecyclerView(recyclerView: RecyclerView, data:List<Movie>?){
    val genres:MutableList<String> = mutableListOf()
    data?.forEach {
        genres.addAll(it.genre)
    }
    val genreList = genres.distinct()
    //data.groupBy { it.genre }
    val actionMovies = data?.filter { it.genre.contains("Thriller") }


    val adapter: PhotoGridAdapter? = recyclerView.adapter as PhotoGridAdapter?
    adapter?.submitList(actionMovies)



}

@BindingAdapter("movieApiStatus")
fun bindStatus(statusImageView: ImageView, status:MovieApiStatus?){
    if (status == MovieApiStatus.LOADING) {
        statusImageView.visibility = View.VISIBLE
        statusImageView.setImageResource(R.drawable.loading_animation)
    }
    else if (status == MovieApiStatus.ERROR) {
        statusImageView.visibility = View.VISIBLE
        statusImageView.setImageResource(R.drawable.ic_connection_error)
    }
    else if (status == MovieApiStatus.DONE) {
        statusImageView.visibility = View.GONE
    }
}