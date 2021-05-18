package com.puspawahyuningtias.metv.di

import com.puspawahyuningtias.metv.data.FilmRepository

object Injection {
    fun provideRepository(): FilmRepository {
        return FilmRepository.getInstance()
    }
}