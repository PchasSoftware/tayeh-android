package ir.pchas.tayehclient.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class Size(
    val height: Int,
    val aroundChest: Int,
    val shoulderWidth: Int,
) : Parcelable {
    XS(55, 88, 32),
    S(56, 92, 33),
    M(57, 96, 34),
    L(58, 100, 34),
    XL(61, 104, 35),
}