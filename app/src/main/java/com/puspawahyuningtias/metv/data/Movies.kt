package com.puspawahyuningtias.metv.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies(
    var name: String,
    var tahun: Int,
    var description: String,
    var photo: Int
): Parcelable