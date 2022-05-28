package com.example.wbsfinancialbackend.datasources.company.stockexchanges

import com.example.wbsfinancialbackend.api.PaginationResponseDTO

data class StockExchangesResponseDTO(
    val pagination: PaginationResponseDTO,
    val data: List<StockExchangeDTO>
)

data class StockExchangeDTO(
    val name: String,
    val acronym: String,
    val city: String?,
    val country: String?,
    val mic: String,
    val website: String?
)