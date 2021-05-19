package com.puspawahyuningtias.metv.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.FilmRepository
import com.puspawahyuningtias.metv.data.Movies
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {
    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<Movies>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataFilm.generateMovies()
        val movies = MutableLiveData<List<Movies>>()
        movies.value = dummyMovies

        `when`(filmRepository.getMovies()).thenReturn(movies)
        val moviesEntities = viewModel.getMovies().value
        verify(filmRepository).getMovies()
        assertNotNull(movies)
        assertEquals(10, moviesEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}