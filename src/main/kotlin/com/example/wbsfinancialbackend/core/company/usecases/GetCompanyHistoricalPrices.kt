package com.example.wbsfinancialbackend.core.company.usecases

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyHistoricalPricesGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.IEXClient
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyPriceDTO

@UseCase
class GetCompanyHistoricalPrices(
    val getCompanyHistoricalPricesGateway: GetCompanyHistoricalPricesGateway
) {

    operator fun invoke(symbol: String, range: String, chartCloseOnly: Boolean): List<CompanyPriceDTO> {
        return getCompanyHistoricalPricesGateway.getHistoricalPrices(symbol, range, chartCloseOnly)
    }
}