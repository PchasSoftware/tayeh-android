package ir.pchas.tayehclient.model.shop

import java.util.*

public data class Source(
    val id: Int,
    val toTransaction_id: Int,
    val toTransaction: Transaction,
    val fromTransaction_id: Int,
    val fromTransaction: Transaction,
    val count: Int,
    val deleted: Boolean,
    val dateCreated: Date,
    val dateUpdated: Date,
    val dateDeleted: Date,
)