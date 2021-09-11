package ir.pchas.tayehclient.repository.network

import com.google.gson.annotations.SerializedName
import ir.pchas.tayehclient.model.Comment

public data class CommentResponse(
    @SerializedName("objects")
    val comments: List<Comment>,
    val count: Int,
)
