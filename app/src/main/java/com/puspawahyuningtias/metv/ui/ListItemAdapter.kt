package com.puspawahyuningtias.metv.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.puspawahyuningtias.metv.databinding.ItemBinding

class ListItemAdapter(private val listItem: ArrayList<Movies>) : RecyclerView.Adapter<ListItemAdapter.ListViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size

    inner class ListViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: Movies) {
            with(binding){
                Glide.with(itemView.context)
                    .load(movies.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(imgItemPhoto)
                tvItemName.text = movies.name
                tvItemDescription.text = movies.description
            }
        }
    }
}