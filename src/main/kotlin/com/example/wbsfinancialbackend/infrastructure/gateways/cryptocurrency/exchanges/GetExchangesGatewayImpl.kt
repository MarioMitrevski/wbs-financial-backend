package com.example.wbsfinancialbackend.infrastructure.gateways.cryptocurrency.exchanges

import com.example.wbsfinancialbackend.core.cryptocurrency.exchanges.gateways.GetExchangesGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.CoinGeckoClient
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.exchanges.ExchangeResponseDTO
import org.springframework.stereotype.Service

@Service
class GetExchangesGatewayImpl(
    val coinGeckoClient: CoinGeckoClient
): GetExchangesGateway {
    override fun getExchanges(page: Int, per_page: Int): List<ExchangeResponseDTO> {
        return coinGeckoClient.getExchanges(page, per_page)
    }
}