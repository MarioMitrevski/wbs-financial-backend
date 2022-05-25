package com.example.wbsfinancialbackend.domain.cryptocurrency.exchanges.usecases

import com.example.wbsfinancialbackend.datasources.CoinGeckoClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.cryptocurrency.exchanges.ExchangesResponseDTO

@UseCase
class GetExchanges(
    val coinGeckoClient: CoinGeckoClient
) {

    operator fun invoke(page: Int, pageSize: Int): List<ExchangesResponseDTO> {
        return coinGeckoClient.getExchanges(page, pageSize)
    }
}