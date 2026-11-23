package com.example.budgettrackerapp

data class Transaction(
    val emoji: String,
    val title: String,
    val subtitle: String,
    val amount: Double,          // negative = expense, positive = income
)

data class CategorySpend(
    val name: String,
    val spent: Double,
    val limit: Double,
) {
    val percent get() = if (limit == 0.0) 0 else ((spent / limit) * 100).toInt()
}

object SampleData {
    val categories = listOf(
        CategorySpend("🏠 Rent", 800.0, 850.0),
        CategorySpend("🍔 Food", 340.0, 400.0),
        CategorySpend("🚌 Transport", 140.0, 120.0),
        CategorySpend("🎬 Fun", 60.0, 150.0),
    )

    val transactions = listOf(
        Transaction("☕", "Starbucks", "Food · Today", -6.45),
        Transaction("💼", "Paycheque", "Income · Nov 15", 1600.00),
        Transaction("🛒", "Save-On-Foods", "Food · Nov 14", -82.30),
        Transaction("🚌", "Compass Card reload", "Transport · Nov 12", -50.00),
        Transaction("🎬", "Cineplex", "Fun · Nov 10", -24.00),
    )
}
