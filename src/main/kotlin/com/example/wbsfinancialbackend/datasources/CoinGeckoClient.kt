package com.example.wbsfinancialbackend.datasources

import com.example.wbsfinancialbackend.constants.endpoints.ClientsEndpoints
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrenciesResponseDTO
import com.example.wbsfinancialbackend.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO
import com.example.wbsfinancialbackend.datasources.cryptocurrency.exchanges.ExchangesResponseDTO
import com.example.wbsfinancialbackend.enums.TimeInterval
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient(
    value = "coingeckoclient",
    url = ClientsEndpoints.COIN_GECKO,
)
interface CoinGeckoClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/coins/{id}"], produces = ["application/json"])
    fun getCryptocurrencyDetails(
        @PathVariable("id") id: String
    ): CryptocurrencyDetailsResponseDTO

    @RequestMapping(method = [RequestMethod.GET], value = ["/coins/markets"], produces = ["application/json"])
    fun getCryptocurrencies(
        @RequestParam("page") page: Int,
        @RequestParam("per_page") perPage: Int,
        @RequestParam("vs_currency") vsCurrency: String,
        @RequestParam("price_change_percentage") priceChangePercentage: String
    ): List<CryptocurrenciesResponseDTO>

    @RequestMapping(method = [RequestMethod.GET], value = ["/exchanges"], produces = ["application/json"])
    fun getExchanges(
        @RequestParam("page") page: Int,
        @RequestParam("per_page") per_page: Int
    ): List<ExchangesResponseDTO>
}