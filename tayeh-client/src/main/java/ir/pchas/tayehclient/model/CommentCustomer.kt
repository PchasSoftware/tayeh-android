package ir.pchas.tayehclient.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CommentCustomer(
    val name: String,
    val avatar: Image,
) : Parcelable
