package com.puspawahyuningtias.metv.ui.tvshow.detail

import com.puspawahyuningtias.metv.data.DataFilm
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val dataTvShow = DataFilm.generateTvShow()[0]
    private val title = dataTvShow.title

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.setSelectedTvShow(title)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dataTvShow.title)
        val tvShow = viewModel.getTvShow()
        assertNotNull(tvShow)
        assertEquals(dataTvShow.title, tvShow.title)
        assertEquals(dataTvShow.description, tvShow.description)
        assertEquals(dataTvShow.photo, tvShow.photo)
        assertEquals(dataTvShow.year, tvShow.year)
        assertEquals(dataTvShow.genre, tvShow.genre)
    }
}