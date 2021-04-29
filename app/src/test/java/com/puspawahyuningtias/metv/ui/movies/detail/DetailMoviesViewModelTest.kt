package com.puspawahyuningtias.metv.ui.movies.detail

import com.puspawahyuningtias.metv.data.DataFilm
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMoviesViewModelTest {
    private lateinit var viewModel: DetailMoviesViewModel
    private val dataMovie = DataFilm.generateMovies()[0]
    private val judul = dataMovie.judul

    @Before
    fun setUp() {
        viewModel = DetailMoviesViewModel()
        viewModel.setSelectedMovies(judul)
    }

    @Test
    fun getMovies() {
        viewModel.setSelectedMovies(dataMovie.judul)
        val movies = viewModel.getMovies()
        assertNotNull(movies)
        assertEquals(dataMovie.judul, movies.judul)
        assertEquals(dataMovie.description, movies.description)
        assertEquals(dataMovie.photo, movies.photo)
        assertEquals(dataMovie.tahun, movies.tahun)
        assertEquals(dataMovie.genre, movies.genre)
    }
}