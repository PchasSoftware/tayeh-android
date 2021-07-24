package ir.pchas.tayehclient.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Brand(
    val name: String,
    val logoImage: Image?,
) : Parcelable