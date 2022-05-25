package com.example.wbsfinancialbackend.datasources.cryptocurrency

import java.math.BigDecimal

data class CryptocurrenciesResponseDTO(
    val id: String,
    val image: String,
    val symbol: String,
    val name: String,
    val current_price: BigDecimal,
    val price_change_percentage_1h_in_currency: Float,
    val price_change_percentage_24h_in_currency: Float,
    val price_change_percentage_7d_in_currency: Float,
    val market_cap: BigDecimal
)