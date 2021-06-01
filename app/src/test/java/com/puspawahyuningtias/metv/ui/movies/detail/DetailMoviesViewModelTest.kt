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
        val courseEntity = viewModel.getMovies().value
        verify(filmRepository).getMovies()
        assertNotNull(courseEntity)
        assertEquals(dataMovies.title, courseEntity?.get(0)?.title)
        assertEquals(dataMovies.description, courseEntity?.get(0)?.description)
        assertEquals(dataMovies.photo, courseEntity?.get(0)?.photo)
        assertEquals(dataMovies.year, courseEntity?.get(0)?.year)
        assertEquals(dataMovies.genre, courseEntity?.get(0)?.genre)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged((dummyMovies))
    }
}
