package com.puspawahyuningtias.metv.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FilmRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Test
    fun getMovies() {
        val dummyMovies = DataFilm.generateMovies()
        val movies = MutableLiveData<List<Movies>>()
        movies.value = dummyMovies

        Mockito.`when`(filmRepository.getMovies()).thenReturn(movies)
        val cek = filmRepository.getMovies().value
        TestCase.assertNotNull(movies)
        TestCase.assertEquals(dummyMovies.size.toLong(), cek?.size?.toLong())
    }

    @Test
    fun getTvShow() {
        val dummyTvShow = DataFilm.generateTvShow()
        val tvShow = MutableLiveData<List<TvShow>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(filmRepository.getTvShow()).thenReturn(tvShow)
        val cek = filmRepository.getTvShow().value
        TestCase.assertNotNull(tvShow)
        TestCase.assertEquals(dummyTvShow.size.toLong(), cek?.size?.toLong())
    }
}