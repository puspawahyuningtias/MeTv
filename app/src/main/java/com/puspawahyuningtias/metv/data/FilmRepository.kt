package com.puspawahyuningtias.metv.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FilmRepository : FilmDataSource {
    companion object {
        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository().apply { instance = this }
            }
    }

    override fun getMovies(): LiveData<List<Movies>> {
        val courseResults = MutableLiveData<List<Movies>>()
        RemoteDataSource.getMovies(object : RemoteDataSource.LoadMovies {
            override fun getMovies(movies: List<Movies>) {
                val courseList = mutableListOf<Movies>()
                for (response in movies) {
                    val course = Movies(
                        response.title,
                        response.year,
                        response.genre,
                        response.description,
                        response.photo
                    )
                    courseList.add(course)
                }
                courseResults.postValue(courseList)
            }
        })
        return courseResults
    }
    override fun getTvShow(): LiveData<List<TvShow>> {
        val tvShowResults = MutableLiveData<List<TvShow>>()
        RemoteDataSource.getTvShow(object : RemoteDataSource.LoadTvShow {
            override fun getTvShow(tvShow: List<TvShow>) {
                val tvShowList = mutableListOf<TvShow>()
                for (response in tvShow) {
                    val course = TvShow(
                        response.title,
                        response.year,
                        response.genre,
                        response.description,
                        response.photo
                    )
                    tvShowList.add(course)
                }
                tvShowResults.postValue(tvShowList)
            }
        })
        return tvShowResults
    }
}