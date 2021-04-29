package com.puspawahyuningtias.metv.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class Movies(
    var name: String,
    var tahun: Int,
    var genre: String,
    var description: String,
    var photo: Int
)
