package com.messiasjunior.digiointerfaceclone.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductDTO(
    val title: String,
    val description: String,
    val imageUrl: String
) : Parcelable
