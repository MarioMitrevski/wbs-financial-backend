package com.example.wbsfinancialbackend.core.company.usecases

import com.example.wbsfinancialbackend.core.company.gateways.GetMarketTopStocksGateway
import com.example.wbsfinancialbackend.infrastructure.api.market.TopStocks
import com.example.wbsfinancialbackend.infrastructure.config.RedisConfig.Companion.MARKET_CACHE_VALUE
import com.example.wbsfinancialbackend.infrastructure.config.RedisConfig.Companion.MARKET_TOP_STOCKS_CACHE_KEY
import com.example.wbsfinancialbackend.infrastructure.datasources.IEXClient
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.MarketTopStocksDTO
import com.example.wbsfinancialbackend.infrastructure.db.company.CompanyRepository
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetMarketTopStocks(
    val getMarketTopStocksGateway: GetMarketTopStocksGateway
) {

    @Cacheable(value = [MARKET_CACHE_VALUE], key = MARKET_TOP_STOCKS_CACHE_KEY)
    operator fun invoke(topStocks: TopStocks): List<MarketTopStocksDTO> {
        val marketTopStocks = when (topStocks) {
            TopStocks.TOP_GAINERS -> {
                getMarketTopStocksGateway.getMarketTopGainers()
            }
            TopStocks.TOP_LOSERS -> {
                getMarketTopStocksGateway.getMarketTopLosers()
            }
        }

        val symbols = marketTopStocks.map { it.symbol }
        val companyLogoProjectionList = getMarketTopStocksGateway.findAllLogosBySymbol(symbols)

        return marketTopStocks.map { marketTopStock ->
            val companyLogoProjection =
                companyLogoProjectionList.find { it.symbol == marketTopStock.symbol }
            marketTopStock.copy(logo = "https://upload.wikimedia.org/wikipedia/commons/f/fa/Apple_logo_black.svg")
        }
    }
}