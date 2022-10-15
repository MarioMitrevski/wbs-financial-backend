package com.example.wbsfinancialbackend.core.cryptocurrency.exchanges.gateways

import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.exchanges.ExchangeResponseDTO

interface GetExchangesGateway {
    fun getExchanges(
        page: Int,
        per_page: Int
    ): List<ExchangeResponseDTO>
}