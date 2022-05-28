package com.example.wbsfinancialbackend.api.company.exchanges

import com.example.wbsfinancialbackend.api.PageRequestDTO
import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.datasources.company.stockexchanges.StockExchangesResponseDTO
import com.example.wbsfinancialbackend.domain.company.stockexchanges.usecases.GetStockExchanges
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.STOCK_EXCHANGES_ENDPOINT])
class StockExchangesController(
    val getStockExchanges: GetStockExchanges
) {

    @GetMapping
    fun getStockExchanges(
        pageRequest: PageRequestDTO,
        @RequestParam("query") query: String
    ): ResponseEntity<StockExchangesResponseDTO> {
        return ResponseEntity.ok(getStockExchanges.invoke(pageRequest, query))
    }
}