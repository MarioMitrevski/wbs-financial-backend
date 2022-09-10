package com.example.wbsfinancialbackend.domain.cryptocurrency.usecases

import com.example.wbsfinancialbackend.api.PageRequestDTO
import com.example.wbsfinancialbackend.api.PaginationResponseDTO
import com.example.wbsfinancialbackend.api.cryptocurrency.dtos.CryptocurrenciesRequest
import com.example.wbsfinancialbackend.constants.endpoints.CRYPTOCURRENCIES_TOTAL
import com.example.wbsfinancialbackend.datasources.CoinGeckoClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrenciesResponseDTO
import com.example.wbsfinancialbackend.utils.isWholeNumber

@UseCase
class GetCryptocurrencies(
    val coinGeckoClient: CoinGeckoClient
) {

    operator fun invoke(
        pageRequestDTO: PageRequestDTO<CryptocurrenciesRequest>
    ): CryptocurrenciesResponseDTO {
        val data =
            coinGeckoClient.getCryptocurrencies(
                pageRequestDTO.page,
                pageRequestDTO.size,
                pageRequestDTO.filterBy.vsCurrency,
                pageRequestDTO.filterBy.priceChangePercentage.joinToString(",")
            )

        val totalPagesDecimal = CRYPTOCURRENCIES_TOTAL / pageRequestDTO.size.toDouble()
        val totalPages = if (isWholeNumber(totalPagesDecimal)) {
            totalPagesDecimal.toInt()
        } else {
            totalPagesDecimal.toInt() + 1
        }
        return CryptocurrenciesResponseDTO(
            pagination = PaginationResponseDTO(
                pageRequestDTO.page,
                CRYPTOCURRENCIES_TOTAL,
                totalPages,
                totalPages.minus(pageRequestDTO.size) > 0,
                pageRequestDTO.size > 1
            ),
            data = data
        )
    }
}