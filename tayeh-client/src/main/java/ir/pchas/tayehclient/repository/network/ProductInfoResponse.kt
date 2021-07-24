package ir.pchas.tayehclient.repository.network

import com.google.gson.annotations.SerializedName
import ir.pchas.tayehclient.model.FeatureGroup

public data class ProductInfoResponse(
    @SerializedName("feature_groups")
    val featureGroups: List<FeatureGroup>
)