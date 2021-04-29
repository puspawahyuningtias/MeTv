package com.puspawahyuningtias.metv.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Movies(
    var judul: String,
    var tahun: String,
    var genre: String,
    var description: String,
    var photo: Int
)
