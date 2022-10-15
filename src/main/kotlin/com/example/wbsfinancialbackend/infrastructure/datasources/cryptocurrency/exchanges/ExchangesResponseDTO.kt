package com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.exchanges

import com.example.wbsfinancialbackend.infrastructure.api.PaginationResponseDTO
import java.math.BigDecimal

data class ExchangesResponseDTO(
    val pagination: PaginationResponseDTO,
    val data: List<ExchangeResponseDTO>
)

data class ExchangeResponseDTO(
    val id: String,
    val name: String,
    val year_established: Int?,
    val country: String?,
    val image: String,
    val trade_volume_24h_btc: BigDecimal,
    val url: String
)