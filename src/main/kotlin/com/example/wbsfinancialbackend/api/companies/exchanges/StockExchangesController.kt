package com.example.wbsfinancialbackend.api.companies.exchanges

import com.example.wbsfinancialbackend.api.PageRequestDTO
import com.example.wbsfinancialbackend.api.companies.exchanges.dtos.StockExchangesRequest
import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.datasources.company.stockexchanges.StockExchangesResponseDTO
import com.example.wbsfinancialbackend.domain.company.stockexchanges.usecases.GetStockExchanges
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