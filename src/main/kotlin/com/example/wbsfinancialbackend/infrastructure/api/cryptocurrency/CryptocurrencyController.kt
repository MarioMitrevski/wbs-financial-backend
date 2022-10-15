package com.example.wbsfinancialbackend.infrastructure.api.cryptocurrency

import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.cryptocurrency.dtos.CryptocurrenciesRequest
import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.core.cryptocurrency.usecases.GetCryptocurrencies
import com.example.wbsfinancialbackend.core.cryptocurrency.usecases.GetCryptocurrencyDetails
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrenciesResponseDTO
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

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

    @PostMapping
    fun getCryptocurrencies(
        @Valid @RequestBody pageRequestDTO: PageRequestDTO<CryptocurrenciesRequest>
    ): ResponseEntity<CryptocurrenciesResponseDTO> {
        return ResponseEntity.ok(getCryptocurrencies.invoke(pageRequestDTO))
    }
}