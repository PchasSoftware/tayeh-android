package ir.pchas.tayehclient.model.shop

import ir.pchas.tayehclient.model.Reminder

public data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val instanceId: Int,
    val instance: Instance,
    val transactions: List<Transaction>,
    val reminders: List<Reminder>,
    val predictedPercent: Int,
    val remaining: Int,
    val deleted: Boolean,
    val dateDeleted: String,
    val dateCreated: String,
)