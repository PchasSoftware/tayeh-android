package ir.pchas.tayehclient.model.user

import ir.pchas.tayehclient.model.shop.Instance
import java.util.*

public data class City(
    val id: Int,
    val provinceId: Int,
    val countyId: Int,
    val name: String,
    val addresses: List<Address>,
    val instances: List<Instance>,
    val users: List<User>,
    val dateCreated: Date,
    val dateUpdated: Date,
)