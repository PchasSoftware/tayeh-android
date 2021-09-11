package ir.pchas.tayehclient.model

data class Customer(
    val name: String?,
    val mobile: String,
    val email: String?,
    val avatar: Image?,
    val id_card: String?,
    val sex: String,
    val birthdate: String?,
    val payment_return_card_number: String?,
)