package ir.pchas.tayehclient.model.shop

import ir.pchas.tayehclient.model.user.User
import java.util.*

data class Payment(
    val id: Int,
    val amount: Int,
    val url: String,
    val paid: Boolean,
    val type: String,
    val userId: Int,
    val subscriptionId: Int,
    val invoiceId: Int,
    val user: User,
    val dateCreated: Date,
    val datePaid: Date,
    val dateUpdated: Date,
    val dateDeleted: Date,
)