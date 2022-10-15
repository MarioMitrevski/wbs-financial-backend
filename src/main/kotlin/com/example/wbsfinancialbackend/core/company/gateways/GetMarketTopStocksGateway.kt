package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.MarketTopStocksDTO
import com.example.wbsfinancialbackend.infrastructure.db.company.CompanyLogoProjection

interface GetMarketTopStocksGateway {
    fun getMarketTopGainers() : List<MarketTopStocksDTO>
    fun getMarketTopLosers() : List<MarketTopStocksDTO>
    fun findAllLogosBySymbol(symbols: List<String>): List<CompanyLogoProjection>
}