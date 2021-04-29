package com.puspawahyuningtias.metv.ui.movies

import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.Movies

class MoviesViewModel : ViewModel() {
    fun getMovies(): List<Movies> = DataFilm.generateMovies()
}