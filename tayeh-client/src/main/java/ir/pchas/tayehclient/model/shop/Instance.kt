package ir.pchas.tayehclient.model.shop

import ir.pchas.tayehclient.model.user.Address

public data class Instance(
    val id: Int,
    val name: String,
    val credit: Int,
    val description: String,
    val type: String,
    val category: String,
    val ownerId: Int,
    val addresses: List<Address>,
    val provinceId: Int,
    val cityId: Int,
    val usersCount: Int,
    val invoicesCount: Int,
    val productsCount: Int,
    val transactionsCount: Int,
    val inventoryType: String,
    val imageId: Int,
)