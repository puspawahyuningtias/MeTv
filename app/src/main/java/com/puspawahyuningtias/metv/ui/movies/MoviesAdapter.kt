package com.puspawahyuningtias.metv.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.puspawahyuningtias.metv.R
import com.puspawahyuningtias.metv.data.Movies
import com.puspawahyuningtias.metv.databinding.ItemBinding
import com.puspawahyuningtias.metv.ui.movies.detail.DetailMoviesActivity
import java.util.ArrayList

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ListViewHolder>(){
    private var listMovies = ArrayList<Movies>()

    fun setMovies(movies: List<Movies>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemsMoviesBinding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size


    class ListViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: Movies) {
            with(binding) {
                tvItemName.text = movies.name
                tvItemDescription.text = movies.description
                tvTahun.text = movies.tahun.toString()
                Glide.with(itemView.context)
                        .load(movies.photo)
                        .apply(
                            RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgItemPhoto)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMoviesActivity::class.java)
                    intent.putExtra(DetailMoviesActivity.EXTRA_MOVIES, movies.name)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}