package com.puspawahyuningtias.metv.data

import androidx.lifecycle.LiveData

interface FilmDataSource {
    fun getMovies(): ArrayList<Movies>
}