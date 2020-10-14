package ir.pchas.tayehclient.model.shop

import ir.pchas.tayehclient.model.user.User
import java.util.*

public data class Subscription(
    val id: Int,
    val user_id: Int,
    val user: User,
    val type: User,
    val payment: Payment,
    val gift: Boolean,
    val active: Boolean,
    val deleted: Boolean,
    val date_created: Date,
    val date_updated: Date,
    val date_deleted: Date,
)