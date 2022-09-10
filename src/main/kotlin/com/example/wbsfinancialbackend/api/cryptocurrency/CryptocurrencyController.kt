package com.example.wbsfinancialbackend.api.cryptocurrency

import com.example.wbsfinancialbackend.api.PageRequestDTO
import com.example.wbsfinancialbackend.api.cryptocurrency.dtos.CryptocurrenciesRequest
import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrenciesResponseDTO
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO
import com.example.wbsfinancialbackend.domain.cryptocurrency.usecases.GetCryptocurrencies
import com.example.wbsfinancialbackend.domain.cryptocurrency.usecases.GetCryptocurrencyDetails
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