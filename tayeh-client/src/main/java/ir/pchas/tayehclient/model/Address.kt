package ir.pchas.tayehclient.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(
    val id: String?,
    val title: String?,
    val description: String?,
    val location: Location?,
    val position: Position?,
    val reciver_name: String?,
    val phone: String?,
    val mobile: String,
    val id_card: String?,
    val postcode: String?,
): Parcelable {
    @Parcelize
    data class Location(
        val countryId: Int?,
        val country_name: String?,
        val country_native_name: String?,
        val stateId: Int?,
        val state_name: String?,
        val state_native_name: String?,
        val cityId: Int?,
        val city_name: String?,
        val city_native_name: String?,
        val verbal: String?,
    ): Parcelable

    @Parcelize
    data class Position(
        val latitude: String?,
        val longitude: String?,
    ): Parcelable
}