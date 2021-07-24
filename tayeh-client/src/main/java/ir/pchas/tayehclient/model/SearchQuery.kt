package ir.pchas.tayehclient.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class SearchQuery(
    val min_price: Int,
    val max_price: Int,
    val brands: List<String>?,
    val category: String?,
    val filter: List<String>?,
    val only_available: Boolean,
): Parcelable
