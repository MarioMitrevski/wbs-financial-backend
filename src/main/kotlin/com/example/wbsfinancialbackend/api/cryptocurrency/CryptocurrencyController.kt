package com.example.wbsfinancialbackend.api.cryptocurrency

import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrenciesResponseDTO
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO
import com.example.wbsfinancialbackend.domain.cryptocurrency.usecases.GetCryptocurrencies
import com.example.wbsfinancialbackend.domain.cryptocurrency.usecases.GetCryptocurrencyDetails
import com.example.wbsfinancialbackend.enums.FiatCurrency
import com.example.wbsfinancialbackend.enums.TimeInterval
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletableFuture
import kotlin.reflect.full.memberProperties


@RestController
@RequestMapping(path = [WBSFinancialEndpoints.CRYPTOCURRENCY_ENDPOINT])
class CryptocurrencyController(
    val cryptocurrencyService: CryptocurrencyService,
    val getCryptocurrencyDetails: GetCryptocurrencyDetails,
    val getCryptocurrencies: GetCryptocurrencies
) {

    @GetMapping(path = ["/{name}/description"])
    fun getCryptocurrencyDescription(@PathVariable("name") name: String): CompletableFuture<String> {
        return cryptocurrencyService.getCryptocurrencyDescription(name)
    }

    @GetMapping(path = ["/{id}/details"])
    fun getCryptocurrencyDetails(@PathVariable("id") id: String): ResponseEntity<CryptocurrencyDetailsResponseDTO> {
        return ResponseEntity.ok(getCryptocurrencyDetails.invoke(id))
    }

    @GetMapping
    fun getCryptocurrencies(
        @RequestParam("page") page: Int,
        @RequestParam("pageSize") pageSize: Int,
        @RequestParam("vsCurrency") vsCurrency: String,
        @RequestParam("priceChangePercentage") priceChangePercentage: List<String>
    ): ResponseEntity<CryptocurrenciesResponseDTO> {
        return ResponseEntity.ok(getCryptocurrencies.invoke(page, pageSize, vsCurrency, priceChangePercentage))
    }
}