package com.puspawahyuningtias.metv.ui.tvshow.detail

import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.ui.movies.detail.DetailMoviesViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailTvShowViewModelTest{
    private lateinit var viewModel: DetailTvShowViewModel
    private val dataTvShow = DataFilm.generateTvShow()[0]
    private val name = dataTvShow.name

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.setSelectedTvShow(name)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dataTvShow.name)
        val tvShow = viewModel.getTvShow()
        assertNotNull(tvShow)
        assertEquals(dataTvShow.name, tvShow.name)
        assertEquals(dataTvShow.description, tvShow.description)
        assertEquals(dataTvShow.photo, tvShow.photo)
        assertEquals(dataTvShow.tahun, tvShow.tahun)
    }
}