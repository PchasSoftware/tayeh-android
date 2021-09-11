package ir.pchas.tayehclient.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ProductChoiceOption(
    val available: Boolean,
    val id: String,
    val name: String,
    val price: Int?,
    @SerializedName("price_with_off")
    val priceWithOff: Int?,
    @SerializedName("off_percent")
    val offPercent: Int?,
) : Parcelable
