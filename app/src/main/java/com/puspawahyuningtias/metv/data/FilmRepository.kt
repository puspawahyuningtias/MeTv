package com.puspawahyuningtias.metv.data

class FilmRepository : FilmDataSource {
    companion object {
        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository().apply { instance = this }
            }
    }

    val courseList = ArrayList<Movies>()
    override fun getMovies(): ArrayList<Movies> {
        RemoteDataSource.getMovies(object : RemoteDataSource.LoadMovies {
            override fun getMovies(movies: ArrayList<Movies>) {
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
            }
        })
        return courseList
    }
}