package com.puspawahyuningtias.metv.ui.tvshow.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.FilmRepository
import com.puspawahyuningtias.metv.data.TvShow
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val dataTvShow = DataFilm.generateTvShow()[0]
    private val title = dataTvShow.title

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<TvShow>>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(filmRepository)
        viewModel.setSelectedTvShow(title)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dataTvShow.title)

        val dummyTvShow = DataFilm.generateTvShow()
        val tvShow = MutableLiveData<List<TvShow>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(filmRepository.getTvShow()).thenReturn(tvShow)
        val tvShowEntitiy = viewModel.getTvShow().value
        Mockito.verify(filmRepository).getTvShow()
        assertNotNull(tvShowEntitiy)
        assertEquals(dataTvShow.title, tvShowEntitiy?.get(0)?.title)
        assertEquals(dataTvShow.description, tvShowEntitiy?.get(0)?.description)
        assertEquals(dataTvShow.photo, tvShowEntitiy?.get(0)?.photo)
        assertEquals(dataTvShow.year, tvShowEntitiy?.get(0)?.year)
        assertEquals(dataTvShow.genre, tvShowEntitiy?.get(0)?.genre)

        viewModel.getTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged((dummyTvShow))
    }
}