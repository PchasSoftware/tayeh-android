package ir.pchas.tayehclient.repository.network

import com.google.gson.annotations.SerializedName
import ir.pchas.tayehclient.model.Product

public data class ProductResponse(
    @SerializedName("objects")
    val products: List<Product>,
    val count: Int
)