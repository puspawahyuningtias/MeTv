package com.puspawahyuningtias.metv.ui.tvshow

import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.TvShow

class TvShowViewModel: ViewModel() {
    fun getTvShow(): List<TvShow> = DataFilm.generateTvShow()

}