package com.example.wbsfinancialbackend.core.cryptocurrency.gateways

import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.cryptocurrency.dtos.CryptocurrenciesRequest
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyResponseDTO

interface GetCryptocurrenciesGateway {
    fun getCryptocurrencies(
        pageRequestDTO: PageRequestDTO<CryptocurrenciesRequest>
    ): List<CryptocurrencyResponseDTO>
}