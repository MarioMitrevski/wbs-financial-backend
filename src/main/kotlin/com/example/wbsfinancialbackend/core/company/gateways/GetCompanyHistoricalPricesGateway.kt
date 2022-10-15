package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyPriceDTO

interface GetCompanyHistoricalPricesGateway {
    fun getHistoricalPrices(symbol: String, range: String, chartCloseOnly: Boolean): List<CompanyPriceDTO>
}