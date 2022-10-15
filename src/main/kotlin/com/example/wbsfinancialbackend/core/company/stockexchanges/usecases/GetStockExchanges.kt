package com.example.wbsfinancialbackend.core.company.stockexchanges.usecases

import com.example.wbsfinancialbackend.core.company.stockexchanges.gateways.GetStockExchangesGateway
import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.companies.exchanges.dtos.StockExchangesRequest
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.company.stockexchanges.StockExchangesResponseDTO

@UseCase
class GetStockExchanges(
    val getStockExchangesGateway: GetStockExchangesGateway
) {

    operator fun invoke(pageRequestDTO: PageRequestDTO<StockExchangesRequest>): StockExchangesResponseDTO {
        return getStockExchangesGateway.getStockExchanges(pageRequestDTO)
    }
}