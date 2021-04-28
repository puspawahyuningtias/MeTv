package com.puspawahyuningtias.metv.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class TvShow(
    var name: String,
    var tahun: Int,
    var description: String,
    var photo: Int
)
