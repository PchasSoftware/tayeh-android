package ir.pchas.tayehclient.repository.network

import com.google.gson.annotations.SerializedName

public data class AuthResponse(
    @SerializedName("access_token")
    val token: String
)