package ir.pchas.tayehclient.repository.network

import ir.pchas.tayehclient.model.SearchFilter

public data class SearchFilterResponse(
    val filters: List<SearchFilter>,
    val brands: List<SearchFilterBrand>,
    val price_filter: PriceFilter
) {
    public data class PriceFilter(
        val min: Int,
        val max: Int,
    )

    public data class SearchFilterBrand(
        val name: String,
        val value: String,
    )
}
