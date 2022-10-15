package com.example.wbsfinancialbackend.infrastructure.gateways.company.stockexchanges

import com.example.wbsfinancialbackend.core.company.stockexchanges.gateways.GetStockExchangesGateway
import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.companies.exchanges.dtos.StockExchangesRequest
import com.example.wbsfinancialbackend.infrastructure.datasources.MarketStackClient
import com.example.wbsfinancialbackend.infrastructure.datasources.company.stockexchanges.StockExchangesResponseDTO
import org.springframework.stereotype.Service

@Service
class GetCompanyStockExchangesGatewayImpl(
    val marketStackClient: MarketStackClient
) : GetStockExchangesGateway {
    override fun getStockExchanges(pageRequestDTO: PageRequestDTO<StockExchangesRequest>): StockExchangesResponseDTO {
        return marketStackClient.getExchanges(
            pageRequestDTO.page,
            pageRequestDTO.size,
            pageRequestDTO.filterBy.query
        )
    }
}