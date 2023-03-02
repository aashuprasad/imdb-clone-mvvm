package com.example.imdbsandbox.favourite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdbsandbox.R
import com.example.imdbsandbox.network.models.Movie

class FavListAdapter(private val dataList:List<Movie>) : RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]
        holder.bindData(data)
    }

    override fun getItemCount() = dataList.size
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val movieImageView = itemView.findViewById<ImageView>(R.id.imageView)
    private val descriptionTextView = itemView.findViewById<TextView>(R.id.textView2)


    fun bindData(data: Movie) {
        // Bind the data to the views in the item layout
        descriptionTextView.text = data.description
        Glide.with(itemView)
            .load(data.imgSrcUrl)
            .into(movieImageView)
    }
}
