package com.example.wbsfinancialbackend.infrastructure.gateways.cryptocurrency

import com.example.wbsfinancialbackend.core.cryptocurrency.gateways.GetCryptocurrencyDetailsGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.CoinGeckoClient
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyMarketDataDTO
import org.springframework.stereotype.Service

@Service
class GetCryptocurrencyDetailsGatewayImpl(
    val coinGeckoClient: CoinGeckoClient
) : GetCryptocurrencyDetailsGateway {
    override fun getCryptocurrencyDetails(id: String): CryptocurrencyDetailsResponseDTO {
        return coinGeckoClient.getCryptocurrencyDetails(id)
    }

    override fun getCryptocurrencyMarketData(id: String): CryptocurrencyMarketDataDTO {
        return coinGeckoClient.getCryptocurrencyDetails(id).market_data
    }
}