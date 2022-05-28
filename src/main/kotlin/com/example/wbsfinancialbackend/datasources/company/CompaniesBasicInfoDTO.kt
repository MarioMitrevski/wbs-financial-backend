package com.example.wbsfinancialbackend.datasources.company

import com.example.wbsfinancialbackend.api.PaginationResponseDTO
import com.example.wbsfinancialbackend.datasources.company.stockexchanges.StockExchangeDTO

data class CompaniesBasicInfoDTO(
    val pagination: PaginationResponseDTO,
    val data: List<CompanyBasicInfoDTO>
)

data class CompanyBasicInfoDTO(
    val name: String,
    val symbol: String,
    val stock_exchange: StockExchangeDTO
)