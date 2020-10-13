package ir.pchas.tayehclient.model.user

import ir.pchas.tayehclient.model.shop.Instance
import java.util.*

data class Province(
    val id: Int,
    val name: String,
    val addresses: List<Address>,
    val instances: List<Instance>,
    val users: List<User>,
    val date_created: Date,
    val date_updated: Date,
)