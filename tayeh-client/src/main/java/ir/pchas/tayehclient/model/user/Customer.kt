package ir.pchas.tayehclient.model.user

import ir.pchas.tayehclient.model.*
import ir.pchas.tayehclient.model.shop.Instance
import ir.pchas.tayehclient.model.shop.Invoice
import java.util.*

public data class Customer(
    val id: Int,
    val name: String,
    val sex: Sex,
    val instanceId: Int,
    val instance: Instance,
    val invoices: List<Invoice>,
    val description: String,
    val idCard: String,
    val father: String,
    val birthdate: String,
    val addresses: List<Address>,
    val phone: String,
    val mobile: String,
    val email: String,
    val website: String,
    val creatorId: Int,
    val creator: User,
    val reminders: List<Reminder>,
    val isVerified: Boolean,
    val socket: String,
    val imageId: Int,
    val image: Media,
    val deleted: Boolean,
    val dateCreated: Date,
    val dateUpdated: Date,
    val dateDeleted: Date,
)