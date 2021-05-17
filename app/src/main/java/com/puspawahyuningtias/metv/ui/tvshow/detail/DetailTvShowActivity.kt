package com.puspawahyuningtias.metv.ui.tvshow.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.puspawahyuningtias.metv.R
import com.puspawahyuningtias.metv.data.TvShow
import com.puspawahyuningtias.metv.databinding.ActivityDetailTvShowBinding

class DetailTvShowActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW = "extra_tv_show"
    }

    private lateinit var binding: ActivityDetailTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val title = extras.getString(EXTRA_TVSHOW)
            if (title != null) {
                viewModel.setSelectedTvShow(title)
                populateTvShow(viewModel.getTvShow())
            }
        }
    }

    private fun populateTvShow(tvShow: TvShow) {
        supportActionBar?.title = tvShow.title
        binding.tvTvshowTitle.text = tvShow.title
        binding.tvTvshowYear.text = tvShow.year
        binding.tvTvshowDeskripsi.text = tvShow.description
        binding.tvTvshowGenre.text = tvShow.genre
        Glide.with(this)
            .load(tvShow.photo)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(binding.ivTvshowPoster)

    }

}