package com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency

import com.example.wbsfinancialbackend.infrastructure.api.PaginationResponseDTO
import java.math.BigDecimal

data class CryptocurrenciesResponseDTO(
    val pagination: PaginationResponseDTO,
    val data: List<CryptocurrencyResponseDTO>
)

data class CryptocurrencyResponseDTO(
    val id: String,
    val image: String,
    val symbol: String,
    val name: String,
    val current_price: BigDecimal,
    val price_change_percentage_1h_in_currency: Float,
    val price_change_percentage_24h_in_currency: Float,
    val price_change_percentage_7d_in_currency: Float,
    val market_cap: BigDecimal,
    val market_cap_rank: Int
)