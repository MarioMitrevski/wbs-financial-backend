package com.example.wbsfinancialbackend.domain.cryptocurrency.usecases

import com.example.wbsfinancialbackend.api.PaginationResponseDTO
import com.example.wbsfinancialbackend.constants.ErrorMessages
import com.example.wbsfinancialbackend.constants.endpoints.CRYPTOCURRENCIES_TOTAL
import com.example.wbsfinancialbackend.datasources.CoinGeckoClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrenciesResponseDTO
import com.example.wbsfinancialbackend.enums.FiatCurrency
import com.example.wbsfinancialbackend.enums.TimeInterval
import com.example.wbsfinancialbackend.exceptions.NotSupportedException
import com.example.wbsfinancialbackend.utils.isWholeNumber

@UseCase
class GetCryptocurrencies(
    val coinGeckoClient: CoinGeckoClient
) {

    operator fun invoke(
        page: Int,
        pageSize: Int,
        vsCurrency: String,
        priceChangePercentage: List<String>
    ): CryptocurrenciesResponseDTO {
        if (!FiatCurrency.values().map { it.value }.contains(vsCurrency)) {
            throw NotSupportedException(ErrorMessages.entityNotSupportedMessage(vsCurrency))
        }
        priceChangePercentage.forEach { timeInterval ->
            if (!TimeInterval.values().map { it.value }.contains(timeInterval)) {
                throw NotSupportedException(ErrorMessages.entityNotSupportedMessage(timeInterval))
            }
        }
        val data =
            coinGeckoClient.getCryptocurrencies(page, pageSize, vsCurrency, priceChangePercentage.joinToString(","))

        val totalPagesDecimal = CRYPTOCURRENCIES_TOTAL / pageSize.toDouble()
        val totalPages = if (isWholeNumber(totalPagesDecimal)) {
            totalPagesDecimal.toInt()
        } else {
            totalPagesDecimal.toInt() + 1
        }
        return CryptocurrenciesResponseDTO(
            pagination = PaginationResponseDTO(
                page,
                CRYPTOCURRENCIES_TOTAL,
                totalPages,
                totalPages.minus(page) > 0,
                page > 1
            ),
            data = data
        )
    }
}