package com.puspawahyuningtias.metv.ui.tvshow.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.metv.data.DataFilm
import com.puspawahyuningtias.metv.data.FilmRepository
import com.puspawahyuningtias.metv.data.TvShow

class DetailTvShowViewModel(private val filmRepository: FilmRepository)  : ViewModel() {
    private lateinit var title: String

    fun setSelectedTvShow(title: String) {
        this.title = title
    }

    fun getTvShow(): LiveData<List<TvShow>> {
        return filmRepository.getTvShow()
    }
}
