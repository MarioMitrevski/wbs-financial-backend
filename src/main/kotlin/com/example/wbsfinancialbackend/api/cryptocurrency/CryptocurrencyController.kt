package com.example.wbsfinancialbackend.api.cryptocurrency

import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrenciesResponseDTO
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO
import com.example.wbsfinancialbackend.domain.cryptocurrency.usecases.GetCryptocurrencies
import com.example.wbsfinancialbackend.domain.cryptocurrency.usecases.GetCryptocurrencyDetails
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.CRYPTOCURRENCY_ENDPOINT])
class CryptocurrencyController(
    val getCryptocurrencyDetails: GetCryptocurrencyDetails,
    val getCryptocurrencies: GetCryptocurrencies
) {

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