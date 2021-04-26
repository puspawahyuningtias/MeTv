package com.puspawahyuningtias.metv.ui

import androidx.lifecycle.ViewModel

class MoviesViewModel: ViewModel() {
    fun getCourses(): List<Movies> = MovieData.generateDummyMovies()

}