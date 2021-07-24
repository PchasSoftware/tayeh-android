package ir.pchas.tayehclient.repository.network

import com.google.gson.annotations.SerializedName
import ir.pchas.tayehclient.model.ShopCardItem

public data class ShopCartResponse(
    val items: List<ShopCardItem>?,
    @SerializedName("total_price")
    val totalPrice: Int,
    @SerializedName("total_price_with_off")
    val totalPriceWithOff: Int,
)
