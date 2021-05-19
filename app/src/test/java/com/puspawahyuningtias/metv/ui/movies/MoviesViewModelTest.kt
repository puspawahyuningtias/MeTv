package com.puspawahyuningtias.metv.ui.movies

import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.FilmRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {
    private lateinit var viewModel: MoviesViewModel

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        `when`(filmRepository.getMovies()).thenReturn(DataFilm.generateMovies())
        val movies = viewModel.getMovies()
        verify<FilmRepository>(filmRepository).getMovies()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }
}