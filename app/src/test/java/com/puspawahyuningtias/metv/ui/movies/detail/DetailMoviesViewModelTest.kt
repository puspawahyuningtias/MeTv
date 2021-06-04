package com.puspawahyuningtias.metv.ui.movies.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.FilmRepository
import com.puspawahyuningtias.metv.data.Movies
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMoviesViewModelTest {
    private lateinit var viewModel: DetailMoviesViewModel
    private val dataMovies = DataFilm.generateMovies()[0]
    private val title = dataMovies.title

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<Movies>>

    @Before
    fun setUp() {
        viewModel = DetailMoviesViewModel(filmRepository)
        viewModel.setSelectedMovies(title)
    }

    @Test
    fun getMovies() {
        viewModel.setSelectedMovies(dataMovies.title)

        val dummyMovies = DataFilm.generateMovies()
        val movies = MutableLiveData<List<Movies>>()
        movies.value = dummyMovies

        `when`(filmRepository.getMovies()).thenReturn(movies)
        val MovieEntitiy = viewModel.getMovies().value
        verify(filmRepository).getMovies()
        assertNotNull(MovieEntitiy)
        assertEquals(dataMovies.title, MovieEntitiy?.get(0)?.title)
        assertEquals(dataMovies.description, MovieEntitiy?.get(0)?.description)
        assertEquals(dataMovies.photo, MovieEntitiy?.get(0)?.photo)
        assertEquals(dataMovies.year, MovieEntitiy?.get(0)?.year)
        assertEquals(dataMovies.genre, MovieEntitiy?.get(0)?.genre)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged((dummyMovies))
    }
}
