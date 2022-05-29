package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.IEXClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.MarketTopStocksDTO
import com.example.wbsfinancialbackend.db.company.CompanyRepository


@UseCase
class GetMarketTopGainers(
    val iexClient: IEXClient,
    val companyRepository: CompanyRepository
) {

    operator fun invoke(): List<MarketTopStocksDTO> {
        val marketTopGainers = iexClient.getMarketTopGainers()

        val symbols = marketTopGainers.map { it.symbol }
        val companyLogoProjectionList = companyRepository.findAllLogosBySymbol(symbols)

        return marketTopGainers.map { marketTopStock ->
            val companyLogoProjection =
                companyLogoProjectionList.find { it.symbol == marketTopStock.symbol }
            marketTopStock.copy(logo = companyLogoProjection?.logoUrl)
        }
    }
}