package ir.pchas.tayehclient.model.user

import ir.pchas.tayehclient.model.shop.Instance
import ir.pchas.tayehclient.model.Reminder
import ir.pchas.tayehclient.model.SubUserStatus
import java.util.*

public data class SubUser(
    val id: Int,
    val instance_id: Int,
    val instance: Instance,
    val user_id: Int,
    val user: User,
    val creator_id: Int,
    val creator: User,
    val reminders: List<Reminder>,
    val status: SubUserStatus,
    val deleted: Boolean,
    val date_created: Date,
    val date_updated: Date,
    val date_deleted: Date,
)