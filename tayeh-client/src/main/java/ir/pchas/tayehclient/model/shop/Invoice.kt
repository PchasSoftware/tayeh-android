package ir.pchas.tayehclient.model.shop

import ir.pchas.tayehclient.model.Reminder
import ir.pchas.tayehclient.model.user.Customer

public data class Invoice(
    val id: Int,
    val invoice_number: Int,
    val fileId: Int,
    val file: String,
    val transactions: List<Transaction>,
    val type: Int,
    val total: Int,
    val payment: Payment,
    val instanceId: Int,
    val instance: Instance,
    val reminders: List<Reminder>,
    val adminId: Int,
    val customerId: Int,
    val customer: Customer,
    val moreInfo: String,
    val sent: Boolean,
    val paid: Boolean,
    val datePaid: String,
    val dateSent: String,
    val done: Boolean,
    val dateArrived: String,
    val closed: Boolean,
    val deleted: Boolean,
    val dateCreated: String,
    val dateUpdated: String,
    val dateDeleted: String,
)