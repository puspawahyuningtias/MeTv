package com.puspawahyuningtias.metv.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies(
    var name: String,
    var description: String,
    var photo: String
): Parcelable
