package com.example.wbsfinancialbackend.core.cryptocurrency.exchanges.usecases

import com.example.wbsfinancialbackend.core.cryptocurrency.exchanges.gateways.GetExchangesGateway
import com.example.wbsfinancialbackend.infrastructure.api.PaginationResponseDTO
import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.CRYPTOCURRENCY_EXCHANGES_TOTAL
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.core.utils.isWholeNumber
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.exchanges.ExchangesResponseDTO

@UseCase
class GetExchanges(
    val getExchangesGateway: GetExchangesGateway
) {

    operator fun invoke(page: Int, pageSize: Int): ExchangesResponseDTO {
        val data = getExchangesGateway.getExchanges(page, pageSize)

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