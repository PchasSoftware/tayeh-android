package ir.pchas.tayehclient.model

data class State(
    val id: Int,
    val state_id: Int?,
    val country_id: Int,
    val name: String,
    val native_name: String?,
)
