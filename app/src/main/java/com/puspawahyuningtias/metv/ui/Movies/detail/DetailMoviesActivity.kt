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
import com.puspawahyuningtias.metv.viewModel.ViewModelFactory

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
        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailMoviesViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val judul = extras.getString(EXTRA_MOVIES)
            if (judul != null) {
                viewModel.setSelectedMovies(judul)
                viewModel.getMovies().observe(this, {
                    lateinit var movies: Movies
                    val dataMovies = it
                    for (dataMovie in dataMovies) {
                        if (dataMovie.title == judul) {
                            movies = dataMovie
                            populateMovies(movies)
                        }
                    }
                })
            }
        }
    }

    private fun populateMovies(movies: Movies) {
        supportActionBar?.title = movies.title
        binding.tvMoviesTitle.text = movies.title
        binding.tvMoviesYear.text = movies.year
        binding.tvMoviesDeskripsi.text = movies.description
        binding.tvMoviesGenre.text = movies.genre
        Glide.with(this)
            .load(movies.photo)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(binding.ivMoviesPoster)

    }

}