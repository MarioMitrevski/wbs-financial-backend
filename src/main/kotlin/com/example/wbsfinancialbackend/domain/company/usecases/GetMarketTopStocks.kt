package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.api.market.TopStocks
import com.example.wbsfinancialbackend.config.RedisConfig.Companion.MARKET_CACHE_VALUE
import com.example.wbsfinancialbackend.config.RedisConfig.Companion.MARKET_TOP_STOCKS_CACHE_KEY
import com.example.wbsfinancialbackend.datasources.IEXClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.MarketTopStocksDTO
import com.example.wbsfinancialbackend.db.company.CompanyRepository
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetMarketTopStocks(
    val iexClient: IEXClient,
    val companyRepository: CompanyRepository
) {

    @Cacheable(value = [MARKET_CACHE_VALUE], key = MARKET_TOP_STOCKS_CACHE_KEY)
    operator fun invoke(topStocks: TopStocks): List<MarketTopStocksDTO> {
        val marketTopStocks = when (topStocks) {
            TopStocks.TOP_GAINERS -> {
                iexClient.getMarketTopGainers()
            }
            TopStocks.TOP_LOSERS -> {
                iexClient.getMarketTopLosers()
            }
        }

        val symbols = marketTopStocks.map { it.symbol }
        val companyLogoProjectionList = companyRepository.findAllLogosBySymbol(symbols)

        return marketTopStocks.map { marketTopStock ->
            val companyLogoProjection =
                companyLogoProjectionList.find { it.symbol == marketTopStock.symbol }
            marketTopStock.copy(logo = companyLogoProjection?.logo)
        }
    }
}