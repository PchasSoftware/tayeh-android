package ir.pchas.tayehclient.model

enum class Sex {
    MALE, FEMALE, NA
}

enum class UserRole {
    USER, MANAGER, ADMIN
}

enum class SubUserStatus {
    PENDING, ACCEPTED, REJECTED
}

enum class InvoiceType {
    SOLD, BOUGHT
}

enum class TransactionType {
    BUY, SELL, INCOME, COST
}