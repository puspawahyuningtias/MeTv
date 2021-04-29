package com.puspawahyuningtias.metv.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.puspawahyuningtias.metv.R
import com.puspawahyuningtias.metv.data.TvShow
import com.puspawahyuningtias.metv.databinding.ItemBinding
import com.puspawahyuningtias.metv.ui.movies.detail.DetailMoviesActivity
import com.puspawahyuningtias.metv.ui.tvshow.detail.DetailTvShowActivity
import java.util.ArrayList

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.ListViewHolder>(){
    private var listTvShow = ArrayList<TvShow>()

    fun setTvShow(TvShow: List<TvShow>?) {
        if (TvShow == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(TvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemsAcademyBinding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemsAcademyBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val course = listTvShow[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listTvShow.size


    class ListViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            with(binding) {
                tvItemName.text = tvShow.judul
                tvItemDescription.text = tvShow.description
                tvItemTahun.text = tvShow.tahun
                Glide.with(itemView.context)
                        .load(tvShow.photo)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgItemPhoto)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvShow.judul)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}