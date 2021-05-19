package com.puspawahyuningtias.metv.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.puspawahyuningtias.metv.data.FilmRepository
import com.puspawahyuningtias.metv.data.TvShow

class TvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getTvShow(): LiveData<List<TvShow>> = filmRepository.getTvShow()
}