package com.example.wbsfinancialbackend.core.cryptocurrency.gateways

import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyMarketDataDTO

interface GetCryptocurrencyDetailsGateway {
    fun getCryptocurrencyDetails(id: String): CryptocurrencyDetailsResponseDTO
    fun getCryptocurrencyMarketData(id: String): CryptocurrencyMarketDataDTO
}