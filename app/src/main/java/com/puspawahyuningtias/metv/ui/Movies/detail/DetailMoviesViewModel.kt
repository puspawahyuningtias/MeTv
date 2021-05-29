package com.puspawahyuningtias.metv.ui.movies.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.metv.data.FilmRepository
import com.puspawahyuningtias.metv.data.Movies

class DetailMoviesViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    private lateinit var judul: String

    fun setSelectedMovies(judul: String) {
        this.judul = judul
    }
    fun getMovies(): LiveData<List<Movies>> {
        return filmRepository.getMovies()
    }
}

