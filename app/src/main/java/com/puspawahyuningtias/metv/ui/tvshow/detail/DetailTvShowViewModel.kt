package com.puspawahyuningtias.metv.ui.tvshow.detail

import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.TvShow

class DetailTvShowViewModel: ViewModel()  {
    private lateinit var judul: String

    fun setSelectedTvShow(judul: String) {
        this.judul = judul
    }

    fun getTvShow(): TvShow {
        lateinit var tvShow: TvShow
        val dataTvShow = DataFilm.generateTvShow()
        for (dataMovie in dataTvShow) {
            if (dataMovie.judul == judul) {
                tvShow = dataMovie
            }
        }
        return tvShow
    }
}
