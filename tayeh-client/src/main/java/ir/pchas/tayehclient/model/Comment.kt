package ir.pchas.tayehclient.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comment(
    val id: String,
    @SerializedName("is_buyer")
    val isBuyer: Boolean,
    val customer: CommentCustomer?,
    val comment: String?,
    @SerializedName("suggestion_status")
    val suggestionStatus: String,
    val response: String?,
    @SerializedName("date_created")
    val date: String,
) : Parcelable