package com.puspawahyuningtias.metv.ui.movies.detail

import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.Movies

class DetailMoviesViewModel : ViewModel() {
    private lateinit var judul: String

    fun setSelectedMovies(judul: String) {
        this.judul = judul
    }

    fun getMovies(): Movies {
        lateinit var movies: Movies
        val dataMovies = DataFilm.generateMovies()
        for (dataMovie in dataMovies) {
            if (dataMovie.judul == judul) {
                movies = dataMovie
            }
        }
        return movies
    }
}
