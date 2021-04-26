package com.puspawahyuningtias.metv.ui.movies.detail

import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.Movies

class DetailMoviesViewModel: ViewModel()  {
    private lateinit var name: String

    fun setSelectedMovies(courseId: String) {
        this.name = courseId
    }

    fun getMovies(): Movies {
        lateinit var movies: Movies
        val dataMovies = DataFilm.generateMovies()
        for (dataMovie in dataMovies) {
            if (dataMovie.name == name) {
                movies = dataMovie
            }
        }
        return movies
    }
}
