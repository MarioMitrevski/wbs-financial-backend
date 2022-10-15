package com.example.wbsfinancialbackend.core.company.stockexchanges.gateways

import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.companies.exchanges.dtos.StockExchangesRequest
import com.example.wbsfinancialbackend.infrastructure.datasources.company.stockexchanges.StockExchangesResponseDTO

interface GetStockExchangesGateway {
    fun getStockExchanges(pageRequestDTO: PageRequestDTO<StockExchangesRequest>): StockExchangesResponseDTO
}