package com.example.wbsfinancialbackend.api.cryptocurrency

import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletableFuture


@RestController
@RequestMapping(path = [WBSFinancialEndpoints.CRYPTOCURRENCY_ENDPOINT])
class CryptocurrencyController(val cryptocurrencyService: CryptocurrencyService) {

    @GetMapping(path = ["/{name}"])
    fun getCryptocurrencyDetails(@PathVariable("name") name: String): CompletableFuture<String> {
        return cryptocurrencyService.getCryptocurrencyDetails(name)
    }
}