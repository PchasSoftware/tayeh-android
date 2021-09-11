package ir.pchas.tayehclient.model

data class Notification(
    val id: String,
    val title: String,
    val message: String,
    val clipboard: String?,
    val dateCreated: String,
    val image: Image?,
    val url: String?,
)
