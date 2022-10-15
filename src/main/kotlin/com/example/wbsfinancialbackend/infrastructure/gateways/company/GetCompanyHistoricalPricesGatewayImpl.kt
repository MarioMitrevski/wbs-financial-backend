package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyHistoricalPricesGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.IEXClient
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyPriceDTO
import org.springframework.stereotype.Service

@Service
class GetCompanyHistoricalPricesGatewayImpl(
    val iexClient: IEXClient
) : GetCompanyHistoricalPricesGateway {
    override fun getHistoricalPrices(symbol: String, range: String, chartCloseOnly: Boolean): List<CompanyPriceDTO> {
        return iexClient.getHistoricalPrices(symbol, range, chartCloseOnly)
    }
}