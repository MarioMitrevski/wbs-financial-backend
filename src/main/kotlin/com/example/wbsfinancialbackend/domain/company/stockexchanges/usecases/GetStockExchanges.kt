package com.example.wbsfinancialbackend.domain.company.stockexchanges.usecases

import com.example.wbsfinancialbackend.api.PageRequestDTO
import com.example.wbsfinancialbackend.constants.endpoints.DEFAULT_PAGE
import com.example.wbsfinancialbackend.constants.endpoints.DEFAULT_PAGE_SIZE
import com.example.wbsfinancialbackend.datasources.MarketStackClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.stockexchanges.StockExchangesResponseDTO

@UseCase
class GetStockExchanges(
    val marketStackClient: MarketStackClient
) {

    operator fun invoke(pageRequestDTO: PageRequestDTO, query: String): StockExchangesResponseDTO {
        return marketStackClient.getExchanges(
            pageRequestDTO.page,
            pageRequestDTO.size,
            query
        )
    }
}