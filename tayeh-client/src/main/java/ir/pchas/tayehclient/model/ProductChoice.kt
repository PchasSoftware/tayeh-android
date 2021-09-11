package ir.pchas.tayehclient.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ProductChoice(
    val title: String,
    val options: List<ProductChoiceOption>,
) : Parcelable
