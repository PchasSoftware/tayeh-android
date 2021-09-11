package com.pchas.mercilady.data.repository.network

data class UpdateCustomerProfileRequest(
    val name: String?,
    val mobile: String,
    val email: String?,
    val avatar_id: String?,
    val id_card: String?,
    val sex: String,
    val birthdate: String?,
    val payment_return_card_number: String?,
)
