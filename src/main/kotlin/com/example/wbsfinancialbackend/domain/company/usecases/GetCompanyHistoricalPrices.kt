package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.IEXClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyPriceDTO

@UseCase
class GetCompanyHistoricalPrices(
    val iexClient: IEXClient
) {

    operator fun invoke(symbol: String, range: String, chartCloseOnly: Boolean): List<CompanyPriceDTO> {
        return iexClient.getHistoricalPrices(symbol, range, chartCloseOnly)
    }
}