package ir.pchas.tayehclient.model

public enum class Sex {
    MALE, FEMALE, NA
}

public enum class UserRole {
    USER, MANAGER, ADMIN
}

public enum class SubUserStatus {
    PENDING, ACCEPTED, REJECTED
}

public enum class InvoiceType {
    SOLD, BOUGHT
}

public enum class TransactionType {
    BUY, SELL, INCOME, COST
}