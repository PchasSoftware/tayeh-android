package ir.pchas.tayehclient.model.shop

import ir.pchas.tayehclient.model.Reminder
import ir.pchas.tayehclient.model.TransactionType

data class Transaction(
    val id: Int,
    val transactionNo: Int,
    val instanceId: Int,
    val instance: Instance,
    val productId: Int,
    val fromSources: Source,
    val toTransactions: Source,
    val reminders: Reminder,
    val count: Int,
    val remaining: Int,
    val value: Int,
    val type: TransactionType,
    val name: String,
    val paid: String,
    val datePaid: String,
    val description: String,
    val invoiceId: Int,
    val options: String,
    val locked: Boolean,
    val archived: Boolean,
    val deleted: Boolean,
    val creatorId: Int,
    val dateCreated: String,
    val dateUpdated: String,
    val dateArchived: String,
    val dateDeleted: String,
)