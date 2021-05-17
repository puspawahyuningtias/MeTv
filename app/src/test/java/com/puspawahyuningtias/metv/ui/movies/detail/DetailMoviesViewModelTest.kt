package com.puspawahyuningtias.metv.ui.movies.detail

import com.puspawahyuningtias.metv.data.DataFilm
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMoviesViewModelTest {
    private lateinit var viewModel: DetailMoviesViewModel
    private val dataMovie = DataFilm.generateMovies()[0]
    private val title = dataMovie.title

    @Before
    fun setUp() {
        viewModel = DetailMoviesViewModel()
        viewModel.setSelectedMovies(title)
    }

    @Test
    fun getMovies() {
        viewModel.setSelectedMovies(dataMovie.title)
        val movies = viewModel.getMovies()
        assertNotNull(movies)
        assertEquals(dataMovie.title, movies.title)
        assertEquals(dataMovie.description, movies.description)
        assertEquals(dataMovie.photo, movies.photo)
        assertEquals(dataMovie.year, movies.year)
        assertEquals(dataMovie.genre, movies.genre)
    }
}