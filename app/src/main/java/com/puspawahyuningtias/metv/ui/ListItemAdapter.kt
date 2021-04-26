package com.puspawahyuningtias.metv.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.puspawahyuningtias.metv.R
import com.puspawahyuningtias.metv.databinding.ItemBinding
import java.util.ArrayList

class ListItemAdapter : RecyclerView.Adapter<ListItemAdapter.ListViewHolder>(){
    private var listCourses = ArrayList<Movies>()

    fun setCourses(courses: List<Movies>?) {
        if (courses == null) return
        this.listCourses.clear()
        this.listCourses.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemsAcademyBinding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val course = listCourses[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourses.size


    class ListViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: Movies) {
            with(binding) {
                tvItemName.text = movies.name
                tvItemDescription.text = movies.description
                Glide.with(itemView.context)
                        .load(movies.photo)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgItemPhoto)
            }
        }
    }
}