package com.example.wbsfinancialbackend.core.cryptocurrency.usecases

import com.example.wbsfinancialbackend.core.cryptocurrency.gateways.GetCryptocurrencyDetailsGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO

@UseCase
class GetCryptocurrencyDetails(
    val getCryptocurrencyDetailsGateway: GetCryptocurrencyDetailsGateway
) {

    operator fun invoke(id: String): CryptocurrencyDetailsResponseDTO {
        return getCryptocurrencyDetailsGateway.getCryptocurrencyDetails(id)
    }
}