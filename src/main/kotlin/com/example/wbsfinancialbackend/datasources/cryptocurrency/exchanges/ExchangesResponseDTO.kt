package com.example.wbsfinancialbackend.datasources.cryptocurrency.exchanges

import java.math.BigDecimal

data class ExchangesResponseDTO(
    val id: String,
    val name: String,
    val year_established: Int?,
    val country: String?,
    val image: String,
    val trade_volume_24h_btc: BigDecimal
)