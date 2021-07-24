package ir.pchas.tayehclient.model

import com.google.gson.annotations.SerializedName

data class Invoice(
    val id: String,
    val status: Int,
    val invoice_number: Int?,
    val items: List<ShopCardItem>?,
    val delivery: Delivery,
    val total_price: Int,
    val total_price_with_off: Int,
    val date_created: String,
){
    data class Delivery(
        @SerializedName("total")
        val totalSendCost: Int,
        val address: InvoiceAddress,
        val status: Int,
        val type: Int,
    ){
        data class InvoiceAddress(
            val phone: String?,
            val mobile: String?,
            val postcode: String,
            val receiver_name: String,
            val id_card: String?,
            val location: Address.Location,
        )
    }
}