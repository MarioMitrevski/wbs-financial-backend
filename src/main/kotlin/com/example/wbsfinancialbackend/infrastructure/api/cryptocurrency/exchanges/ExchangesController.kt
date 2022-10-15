package com.example.wbsfinancialbackend.infrastructure.api.cryptocurrency.exchanges

import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.core.cryptocurrency.exchanges.usecases.GetExchanges
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.exchanges.ExchangesResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.CRYPTOCURRENCY_EXCHANGES_ENDPOINT])
class ExchangesController(
    val getExchanges: GetExchanges
) {

    @GetMapping
    fun getExchanges(
        @RequestParam("page") page: Int,
        @RequestParam("pageSize") pageSize: Int
    ): ResponseEntity<ExchangesResponseDTO> {
        return ResponseEntity.ok(getExchanges.invoke(page,pageSize))
    }
}