package com.puspawahyuningtias.metv.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.FilmRepository
import com.puspawahyuningtias.metv.data.Movies

class MoviesViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getMovies(): List<Movies> = filmRepository.getMovies()
}