package com.example.wbsfinancialbackend.core.cryptocurrency.usecases

import com.example.wbsfinancialbackend.core.cryptocurrency.gateways.GetCryptocurrenciesGateway
import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.PaginationResponseDTO
import com.example.wbsfinancialbackend.infrastructure.api.cryptocurrency.dtos.CryptocurrenciesRequest
import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.CRYPTOCURRENCIES_TOTAL
import com.example.wbsfinancialbackend.infrastructure.datasources.CoinGeckoClient
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.core.utils.isWholeNumber
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrenciesResponseDTO

@UseCase
class GetCryptocurrencies(
    val getCryptocurrenciesGateway: GetCryptocurrenciesGateway
) {

    operator fun invoke(
        pageRequestDTO: PageRequestDTO<CryptocurrenciesRequest>
    ): CryptocurrenciesResponseDTO {
        val data = getCryptocurrenciesGateway.getCryptocurrencies(pageRequestDTO)

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