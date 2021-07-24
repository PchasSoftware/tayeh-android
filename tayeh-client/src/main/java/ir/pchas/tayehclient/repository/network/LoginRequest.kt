package ir.pchas.tayehclient.repository.network

public data class LoginRequest(
    val instance: Int,
    val mobile: String,
    val verification_code: String?,
)
