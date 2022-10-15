package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.gateways.GetMarketTopStocksGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.IEXClient
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.MarketTopStocksDTO
import com.example.wbsfinancialbackend.infrastructure.db.company.CompanyLogoProjection
import com.example.wbsfinancialbackend.infrastructure.db.company.CompanyRepository
import org.springframework.stereotype.Service

@Service
class GetMarketTopStocksGatewayImpl(
    val iexClient: IEXClient,
    val companyRepository: CompanyRepository
) : GetMarketTopStocksGateway {
    override fun getMarketTopGainers(): List<MarketTopStocksDTO> {
        return iexClient.getMarketTopGainers()
    }

    override fun getMarketTopLosers(): List<MarketTopStocksDTO> {
        return iexClient.getMarketTopLosers()
    }

    override fun findAllLogosBySymbol(symbols: List<String>): List<CompanyLogoProjection> {
        return companyRepository.findAllLogosBySymbol(symbols)
    }

}