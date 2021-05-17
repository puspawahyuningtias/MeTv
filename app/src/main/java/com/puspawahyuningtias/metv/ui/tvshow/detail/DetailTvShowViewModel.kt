package com.puspawahyuningtias.metv.ui.tvshow.detail

import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.TvShow

class DetailTvShowViewModel : ViewModel() {
    private lateinit var title: String

    fun setSelectedTvShow(title: String) {
        this.title = title
    }

    fun getTvShow(): TvShow {
        lateinit var tvShow: TvShow
        val dataTvShow = DataFilm.generateTvShow()
        for (dataMovie in dataTvShow) {
            if (dataMovie.title == title) {
                tvShow = dataMovie
            }
        }
        return tvShow
    }
}
