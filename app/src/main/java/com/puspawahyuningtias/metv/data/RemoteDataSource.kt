package com.puspawahyuningtias.metv.data

import android.os.Handler
import android.os.Looper
import com.puspawahyuningtias.metv.utils.EspressoIdlingResource

object RemoteDataSource {
    fun getMovies(callback: LoadMovies) {
        EspressoIdlingResource.increment()
        Handler(Looper.getMainLooper()).postDelayed({
            callback.getMovies(DataFilm.generateMovies())
            EspressoIdlingResource.decrement()
        }, 2000)
    }
    fun getMoviesByJudul(judul:String,callback: LoadMoviesByJudul) {
        EspressoIdlingResource.increment()
        Handler(Looper.getMainLooper()).postDelayed({
            callback.getMoviesByJudul(DataFilm.generateMovies())
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

    interface LoadMoviesByJudul {
        fun getMoviesByJudul(movies: List<Movies>)
    }

    interface LoadTvShow {
        fun getTvShow(tvShow: List<TvShow>)
    }
}