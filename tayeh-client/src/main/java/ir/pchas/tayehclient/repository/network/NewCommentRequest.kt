package ir.pchas.tayehclient.repository.network

import com.google.gson.annotations.SerializedName
import ir.pchas.tayehclient.model.RatingSend

public data class NewCommentRequest(
    @SerializedName("product_id")
    val productId: String,
    val comment: String,
    @SerializedName("suggestion_status")
    val suggestionStatus: String,
    val ratings: List<RatingSend>?
)
