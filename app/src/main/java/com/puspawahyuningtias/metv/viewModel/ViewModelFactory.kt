package com.puspawahyuningtias.metv.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.puspawahyuningtias.metv.data.FilmRepository
import com.puspawahyuningtias.metv.data.Movies
import com.puspawahyuningtias.metv.di.Injection
import com.puspawahyuningtias.metv.ui.movies.MoviesViewModel
import com.puspawahyuningtias.metv.ui.tvshow.TvShowViewModel

class ViewModelFactory(private val mfilmRepository: FilmRepository)  :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Injection.provideRepository()).apply {
                instance = this
            }
        }
    }
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(mfilmRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mfilmRepository) as T
            }
            else -> throw Throwable("Unknown viewModel class: " + modelClass.name)
        }
    }
}