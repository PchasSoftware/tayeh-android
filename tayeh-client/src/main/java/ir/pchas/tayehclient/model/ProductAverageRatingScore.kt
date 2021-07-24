package ir.pchas.tayehclient.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ProductAverageRatingScore(
    val name: String,
    val score: Double,
    val max: Int,
) : Parcelable
