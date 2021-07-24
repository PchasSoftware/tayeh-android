package ir.pchas.tayehclient.model

enum class Sex {
    MALE,
    FEMALE,
    NA,
}

enum class UserRole {
    USER,
    MANAGER,
    ADMIN,
}

enum class SubUserStatus {
    PENDING,
    ACCEPTED,
    REJECTED,
}

enum class InvoiceType {
    SOLD,
    BOUGHT,
}

enum class TransactionType {
    BUY,
    SELL,
    INCOME,
    COST,
}

enum class ProductType {
    TOP_SELL,
    NEW,
    TODAY
}

enum class ProductSort(val title: String, val persianTitle: String){
    FRESH("fresh", "جدیدترین ها"),
    LOW_PRICE("price_low_2_high", "کمترین قیمت"),
    HIGH_PRICE("price_high_2_low", "بیشترین قیمت"),
    DISCOUNT("discount", "بیشترین تخفیف"),
    BEST_SELLER("bestsellers", "بیشترین فروش")
}