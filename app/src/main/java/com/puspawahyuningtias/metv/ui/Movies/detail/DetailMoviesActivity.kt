package com.puspawahyuningtias.metv.ui.movies.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.puspawahyuningtias.metv.R
import com.puspawahyuningtias.metv.data.Movies
import com.puspawahyuningtias.metv.databinding.ActivityDetailMoviesBinding

class DetailMoviesActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIES = "extra_movies"
    }

    private lateinit var binding: ActivityDetailMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMoviesViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val name = extras.getString(EXTRA_MOVIES)
            if (name != null) {
                viewModel.setSelectedMovies(name)
                populateMovies(viewModel.getMovies())
            }
        }
    }

    private fun populateMovies(movies: Movies) {
        supportActionBar?.title = movies.name
        binding.tvJudul.text = movies.name
        binding.tvTahun.text = movies.tahun.toString()
        binding.tvDeskripsi.text = movies.description
        binding.tvGenre.text = movies.genre
        Glide.with(this)
            .load(movies.photo)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(binding.ivPoster)

    }

}