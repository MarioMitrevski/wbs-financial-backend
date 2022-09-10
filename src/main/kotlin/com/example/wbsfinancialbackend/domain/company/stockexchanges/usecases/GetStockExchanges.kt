package com.example.wbsfinancialbackend.domain.company.stockexchanges.usecases

import com.example.wbsfinancialbackend.api.PageRequestDTO
import com.example.wbsfinancialbackend.api.companies.exchanges.dtos.StockExchangesRequest
import com.example.wbsfinancialbackend.datasources.MarketStackClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.stockexchanges.StockExchangesResponseDTO

@UseCase
class GetStockExchanges(
    val marketStackClient: MarketStackClient
) {

    operator fun invoke(pageRequestDTO: PageRequestDTO<StockExchangesRequest>): StockExchangesResponseDTO {
        return marketStackClient.getExchanges(
            pageRequestDTO.page,
            pageRequestDTO.size,
            pageRequestDTO.filterBy.query
        )
    }
}