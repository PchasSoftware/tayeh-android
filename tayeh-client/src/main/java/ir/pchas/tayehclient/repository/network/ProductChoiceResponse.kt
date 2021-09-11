package ir.pchas.tayehclient.repository.network

import com.google.gson.annotations.SerializedName
import ir.pchas.tayehclient.model.ProductChoice

public data class ProductChoiceResponse(
    @SerializedName("price_choice")
    val priceChoice: ProductChoice,
    @SerializedName("other_choices")
    val otherChoices: List<ProductChoice>,
)
