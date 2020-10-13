package ir.pchas.tayehclient.model

import ir.pchas.tayehclient.model.shop.Instance
import ir.pchas.tayehclient.model.shop.Invoice
import ir.pchas.tayehclient.model.shop.Product
import ir.pchas.tayehclient.model.user.Customer
import ir.pchas.tayehclient.model.user.User
import java.util.*

public data class Media(
    val id: Int,
    val name: String,
    val description: String,
    val file: String,
    val type: String,
    val instanceId: Int,
    val instance: Instance,
    val products: List<Product>,
    val user: User,
    val imageOfInstance: Instance,
    val customer: Customer,
    val invoice: Invoice,
    val uploaderId: Int,
    val uploader: User,
    val creatorType: String,
    val deleted: Boolean,
    val dateDeleted: Date,
    val creatorId: Int,
    val dateCreated: Date,
)