package com.puspawahyuningtias.metv.ui.tvshow.detail

import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.TvShow

class DetailTvShowViewModel: ViewModel()  {
    private lateinit var name: String

    fun setSelectedTvShow(courseId: String) {
        this.name = courseId
    }

    fun getTvShow(): TvShow {
        lateinit var tvShow: TvShow
        val dataTvShow = DataFilm.generateTvShow()
        for (dataMovie in dataTvShow) {
            if (dataMovie.name == name) {
                tvShow = dataMovie
            }
        }
        return tvShow
    }
}
