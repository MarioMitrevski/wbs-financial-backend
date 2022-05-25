package com.example.wbsfinancialbackend.domain.cryptocurrency.usecases

import com.example.wbsfinancialbackend.datasources.CoinGeckoClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO

@UseCase
class GetCryptocurrencyDetails(
    val coinGeckoClient: CoinGeckoClient
) {

    operator fun invoke(id: String): CryptocurrencyDetailsResponseDTO {
        return coinGeckoClient.getCryptocurrencyDetails(id)
    }
}