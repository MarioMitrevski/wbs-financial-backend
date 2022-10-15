package com.example.wbsfinancialbackend.infrastructure.api.companies.exchanges

import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.companies.exchanges.dtos.StockExchangesRequest
import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.core.company.stockexchanges.usecases.GetStockExchanges
import com.example.wbsfinancialbackend.infrastructure.datasources.company.stockexchanges.StockExchangesResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.STOCK_EXCHANGES_ENDPOINT])
class StockExchangesController(
    val getStockExchanges: GetStockExchanges
) {

    @PostMapping
    fun getStockExchanges(
        @Valid @RequestBody pageRequestDTO: PageRequestDTO<StockExchangesRequest>
    ): ResponseEntity<StockExchangesResponseDTO> {
        return ResponseEntity.ok(getStockExchanges.invoke(pageRequestDTO))
    }
}