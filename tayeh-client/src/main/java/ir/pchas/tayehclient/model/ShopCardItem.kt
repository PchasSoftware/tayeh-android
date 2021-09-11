package ir.pchas.tayehclient.model

import com.google.gson.annotations.SerializedName

data class ShopCardItem(
    @SerializedName("id")
    val productId: String,
    val name: String,
    val image: Image?,
    val count: Int,
    val remaining: Int,
    val price: Int,
    @SerializedName("price_with_off")
    val priceWithOff: Int,
    @SerializedName("off_percent")
    val offPercent: Int,
    @SerializedName("cart_item_id")
    val cartItemId: String,
    @SerializedName("price_choice")
    val priceChoice: ShopCartProductChoiceOption?,
    val currency: String,
)