package com.puspawahyuningtias.metv.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies(
    var title: String,
    val year: String,
    var genre: String,
    var description: String,
    var photo: Int
) : Parcelable
