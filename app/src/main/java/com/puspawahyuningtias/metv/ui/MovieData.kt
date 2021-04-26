package com.puspawahyuningtias.metv.ui

import android.graphics.Movie
import com.puspawahyuningtias.metv.R

object MovieData {
    fun generateDummyMovies(): List<Movies> {
        val movies = ArrayList<Movies>()

        movies.add(Movies(
                "A Star Is Born",
                "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                R.drawable.poster_a_start_is_born
        ))
        return movies
    }

}