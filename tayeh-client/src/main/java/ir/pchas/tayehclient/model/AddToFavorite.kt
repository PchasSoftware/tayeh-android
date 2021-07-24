package ir.pchas.tayehclient.model

import com.google.gson.annotations.SerializedName

data class AddToFavorite(
    @SerializedName("product_id")
    val productId: String,
    val favorite: Boolean,
)
