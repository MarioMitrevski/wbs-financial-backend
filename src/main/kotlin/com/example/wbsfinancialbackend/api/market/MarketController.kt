package com.example.wbsfinancialbackend.api.market

import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.datasources.company.dtos.MarketTopStocksDTO
import com.example.wbsfinancialbackend.domain.company.usecases.GetMarketTopGainers
import com.example.wbsfinancialbackend.domain.company.usecases.GetMarketTopLosers
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.MARKET_ENDPOINT])
class MarketController(
    val getMarketTopGainers: GetMarketTopGainers,
    val getMarketTopLosers: GetMarketTopLosers
) {

    @GetMapping("/top-gainers")
    fun getMarketTopGainers(): ResponseEntity<List<MarketTopStocksDTO>> {
        return ResponseEntity.ok(getMarketTopGainers.invoke())
    }

    @GetMapping("/top-losers")
    fun getMarketTopLosers(): ResponseEntity<List<MarketTopStocksDTO>> {
        return ResponseEntity.ok(getMarketTopLosers.invoke())
    }
}