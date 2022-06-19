package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.IEXClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.MarketTopStocksDTO
import com.example.wbsfinancialbackend.db.company.CompanyRepository

@UseCase
class GetMarketTopLosers(
    val iexClient: IEXClient,
    val companyRepository: CompanyRepository
) {

    operator fun invoke(): List<MarketTopStocksDTO> {
        val marketTopLosers = iexClient.getMarketTopLosers()

        val symbols = marketTopLosers.map { it.symbol }
        val companyLogoProjectionList = companyRepository.findAllLogosBySymbol(symbols)

        return marketTopLosers.map { marketTopStock ->
            val companyLogoProjection =
                companyLogoProjectionList.find { it.symbol == marketTopStock.symbol }
            marketTopStock.copy(logo = companyLogoProjection?.logo)
        }
    }
}