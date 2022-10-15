package com.example.wbsfinancialbackend.infrastructure.gateways.cryptocurrency

import com.example.wbsfinancialbackend.core.cryptocurrency.gateways.GetCryptocurrenciesGateway
import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.cryptocurrency.dtos.CryptocurrenciesRequest
import com.example.wbsfinancialbackend.infrastructure.datasources.CoinGeckoClient
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyResponseDTO
import org.springframework.stereotype.Service

@Service
class GetCryptocurrenciesGatewayImpl(
    val coinGeckoClient: CoinGeckoClient
): GetCryptocurrenciesGateway {
    override fun getCryptocurrencies(
        pageRequestDTO: PageRequestDTO<CryptocurrenciesRequest>
    ): List<CryptocurrencyResponseDTO> {
        return coinGeckoClient.getCryptocurrencies(
            pageRequestDTO.page,
            pageRequestDTO.size,
            pageRequestDTO.filterBy.vsCurrency,
            pageRequestDTO.filterBy.priceChangePercentage.joinToString(",")
        )
    }
}