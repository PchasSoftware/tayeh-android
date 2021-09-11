package ir.pchas.tayehclient.model

data class SearchFilter(
    val type: String,
    val id: String?,
    val label: String,
    val options: List<FilterOption>?,
    val min: Int?,
    val max: Int?,
) {
    data class FilterOption(
        val name: String,
        val value: String,
    )
}
