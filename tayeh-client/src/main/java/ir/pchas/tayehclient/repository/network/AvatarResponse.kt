package ir.pchas.tayehclient.repository.network

public data class AvatarResponse(
    val err: String?,
    val media: ResponseMedia,
    val url: String,
) {
    public data class ResponseMedia(
        val id: String,
        val alt: String,
    )
}
