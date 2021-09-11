package ir.pchas.tayehclient.repository.network

import ir.pchas.tayehclient.model.Notification

public data class NotificationResponse(
    val objects: List<Notification>,
    val count: Int,
)
