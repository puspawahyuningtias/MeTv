package com.puspawahyuningtias.metv.data

import androidx.lifecycle.LiveData

interface FilmDataSource {
    fun getMovies(): LiveData<List<Movies>>
    fun getTvShow(): LiveData<List<TvShow>>
//    fun getMoviesByJudul(judul: String): LiveData<List<Movies>>
//    fun getTvShowByJudul(judul: String): LiveData<List<Movies>>
}