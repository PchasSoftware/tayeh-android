package ir.pchas.tayehclient.model

data class AddToCartRequest(
    val product_id: String,
    val price_id: String?,
    val choices: List<String>?,
)
