package com.example.wbsfinancialbackend.core.cryptocurrency.gateways

import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO

interface GetCryptocurrencyDetailsGateway {
    fun getCryptocurrencyDetails(id: String): CryptocurrencyDetailsResponseDTO
}