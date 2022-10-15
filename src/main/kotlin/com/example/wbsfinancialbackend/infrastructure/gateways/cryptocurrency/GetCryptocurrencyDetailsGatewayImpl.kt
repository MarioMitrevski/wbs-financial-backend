package com.example.wbsfinancialbackend.infrastructure.gateways.cryptocurrency

import com.example.wbsfinancialbackend.core.cryptocurrency.gateways.GetCryptocurrencyDetailsGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.CoinGeckoClient
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO
import org.springframework.stereotype.Service

@Service
class GetCryptocurrencyDetailsGatewayImpl(
    val coinGeckoClient: CoinGeckoClient
) : GetCryptocurrencyDetailsGateway {
    override fun getCryptocurrencyDetails(id: String): CryptocurrencyDetailsResponseDTO {
        return coinGeckoClient.getCryptocurrencyDetails(id)
    }
}