package ir.pchas.tayehclient.model.user

import ir.pchas.tayehclient.model.Reminder
import ir.pchas.tayehclient.model.shop.Instance

data class Address(
    val id: Int,
    val provinceId: Int,
    val cityId: Int,
    val lat: String,
    val lng: String,
    val address: String,
    val userId: Int,
    val user: User,
    val reminders: List<Reminder>,
    val primaryAddress: Boolean,
    val instanceId: Int,
    val instance: Instance,
    val title: String,
    val description: String,
    val phone: String,
    val creatorId: Int,
    val deleted: Boolean,
    val dateCreated: String,
    val dateUpdated: String,
    val dateDeleted: String,
)