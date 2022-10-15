package com.example.wbsfinancialbackend.infrastructure.api.market

import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.core.company.usecases.GetMarketTopStocks
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.MarketTopStocksDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.MARKET_ENDPOINT])
class MarketController(
    val getMarketTopStocks: GetMarketTopStocks
) {

    @GetMapping("/{topStocks}")
    fun getMarketTopStocks(@PathVariable topStocks: String): ResponseEntity<List<MarketTopStocksDTO>> {
        return ResponseEntity.ok(getMarketTopStocks.invoke(TopStocks.valueOf(topStocks)))
    }
}