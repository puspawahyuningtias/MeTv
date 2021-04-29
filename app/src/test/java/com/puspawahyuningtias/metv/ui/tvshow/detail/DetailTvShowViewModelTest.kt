package com.puspawahyuningtias.metv.ui.tvshow.detail

import com.puspawahyuningtias.metv.data.DataFilm
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val dataTvShow = DataFilm.generateTvShow()[0]
    private val judul = dataTvShow.judul

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.setSelectedTvShow(judul)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dataTvShow.judul)
        val tvShow = viewModel.getTvShow()
        assertNotNull(tvShow)
        assertEquals(dataTvShow.judul, tvShow.judul)
        assertEquals(dataTvShow.description, tvShow.description)
        assertEquals(dataTvShow.photo, tvShow.photo)
        assertEquals(dataTvShow.tahun, tvShow.tahun)
        assertEquals(dataTvShow.genre, tvShow.genre)
    }
}