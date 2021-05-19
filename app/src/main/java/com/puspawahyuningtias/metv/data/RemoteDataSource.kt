package com.puspawahyuningtias.metv.data

import android.icu.number.Precision.increment
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import com.puspawahyuningtias.metv.utils.EspressoIdlingResource
import javax.security.auth.callback.Callback

object RemoteDataSource {
    fun getMovies(callback: LoadMovies) {
        EspressoIdlingResource.increment()
        Handler(Looper.getMainLooper()).postDelayed({
            callback.getMovies(DataFilm.generateMovies())
            EspressoIdlingResource.decrement()
        }, 2000)
    }
    fun getTvShow(callback: LoadTvShow) {
        EspressoIdlingResource.increment()
        Handler(Looper.getMainLooper()).postDelayed({
            callback.getTvShow(DataFilm.generateTvShow())
            EspressoIdlingResource.decrement()
        }, 2000)
    }

    interface LoadMovies {
        fun getMovies(movies: List<Movies>)
    }

    interface LoadTvShow {
        fun getTvShow(tvShow: List<TvShow>)
    }
}