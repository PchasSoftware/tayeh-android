package ir.pchas.tayehclient.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Product(
    val id: String,
    val available: Boolean,
    val name: String,
    val description: String?,
    val price: Int,
    @SerializedName("price_with_off")
    val priceWithOff: Int,
    @SerializedName("off_percent")
    val offPercent: Int,
    val currency: String,
    val image: Image?,
    val category: String?,
    val brand: Brand?,
    @SerializedName("rating_score")
    val ratingScore: String?,
    @SerializedName("rating_count")
    val ratingCount: String?,
    @SerializedName("comments_count")
    val commentsCount: String?,
    val favorite: Boolean,
) : Parcelable