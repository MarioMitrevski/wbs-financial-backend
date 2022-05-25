package com.example.wbsfinancialbackend.domain.cryptocurrency.usecases

import com.example.wbsfinancialbackend.datasources.CoinGeckoClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrenciesResponseDTO
import com.example.wbsfinancialbackend.enums.FiatCurrency
import com.example.wbsfinancialbackend.enums.TimeInterval

@UseCase
class GetCryptocurrencies(
    val coinGeckoClient: CoinGeckoClient
) {

    operator fun invoke(
        page: Int,
        pageSize: Int,
        vsCurrency: String,
        priceChangePercentage: List<String>
    ): List<CryptocurrenciesResponseDTO> {
        if (!FiatCurrency.values().map { it.value }.contains(vsCurrency)) {
            throw IllegalArgumentException("Not supported currency $vsCurrency!")
        }
        priceChangePercentage.forEach { timeInterval ->
            if (!TimeInterval.values().map { it.value }.contains(timeInterval)) {
                throw IllegalArgumentException("Not supported time interval $timeInterval!")
            }
        }
        return coinGeckoClient.getCryptocurrencies(page, pageSize, vsCurrency, priceChangePercentage.joinToString(","))
    }
}