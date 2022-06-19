package com.example.wbsfinancialbackend.domain.cryptocurrency.exchanges.usecases

import com.example.wbsfinancialbackend.api.PaginationResponseDTO
import com.example.wbsfinancialbackend.constants.endpoints.CRYPTOCURRENCY_EXCHANGES_TOTAL
import com.example.wbsfinancialbackend.datasources.CoinGeckoClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.cryptocurrency.exchanges.ExchangesResponseDTO
import com.example.wbsfinancialbackend.utils.isWholeNumber

@UseCase
class GetExchanges(
    val coinGeckoClient: CoinGeckoClient
) {

    operator fun invoke(page: Int, pageSize: Int): ExchangesResponseDTO {
        val data = coinGeckoClient.getExchanges(page, pageSize)

        val totalPagesDecimal = CRYPTOCURRENCY_EXCHANGES_TOTAL / pageSize.toDouble()
        val totalPages = if (isWholeNumber(totalPagesDecimal)) {
            totalPagesDecimal.toInt()
        } else {
            totalPagesDecimal.toInt() + 1
        }
        return ExchangesResponseDTO(
            pagination = PaginationResponseDTO(
                page,
                CRYPTOCURRENCY_EXCHANGES_TOTAL,
                totalPages,
                totalPages.minus(page) > 0,
                page > 1
            ),
            data = data
        )
    }
}