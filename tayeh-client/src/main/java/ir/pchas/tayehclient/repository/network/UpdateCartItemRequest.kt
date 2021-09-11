package com.pchas.mercilady.data.repository.network

import com.google.gson.annotations.SerializedName

data class UpdateCartItemRequest(
    @SerializedName("cart_item_id")
    val id: String,
    val count: Int,
)
