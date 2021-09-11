package ir.pchas.tayehclient.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Image(
    val id: String?,
    val url: String?,
    val alt: String?,
): Parcelable
