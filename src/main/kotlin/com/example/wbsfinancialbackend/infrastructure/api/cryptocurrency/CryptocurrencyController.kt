package com.example.wbsfinancialbackend.infrastructure.api.cryptocurrency

import com.example.wbsfinancialbackend.core.cryptocurrency.usecases.GetCryptocurrencies
import com.example.wbsfinancialbackend.core.cryptocurrency.usecases.GetCryptocurrencyDetails
import com.example.wbsfinancialbackend.core.cryptocurrency.usecases.GetCryptocurrencyMarketData
import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.cryptocurrency.dtos.CryptocurrenciesRequest
import com.example.wbsfinancialbackend.infrastructure.config.RedisConfig
import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrenciesResponseDTO
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyDetailsResponseDTO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.apache.jena.base.Sys
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.validation.Valid

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.CRYPTOCURRENCY_ENDPOINT])
class CryptocurrencyController(
    val getCryptocurrencyDetails: GetCryptocurrencyDetails,
    val getCryptocurrencies: GetCryptocurrencies,
    val getCryptocurrencyMarketData: GetCryptocurrencyMarketData
) {

    private val executorService: ExecutorService = Executors.newCachedThreadPool()

    @GetMapping(path = ["/{id}/details"])
    fun getCryptocurrencyDetails(@PathVariable("id") id: String): ResponseEntity<CryptocurrencyDetailsResponseDTO> {
        return ResponseEntity.ok(getCryptocurrencyDetails.invoke(id))
    }

    @GetMapping(path = ["/{id}/marketData-sse"])
    fun getCryptocurrencyMarketDataSse(@PathVariable("id") id: String): SseEmitter {
        val emitter = SseEmitter(secondsToMilliseconds(3600))
        executorService.execute {
            try {
                while (true) {
                    runBlocking {
                        launch {
                            emitter.send(getCryptocurrencyMarketData.invoke(id))
                            delay(secondsToMilliseconds(RedisConfig.CRYPTO_MARKET_DATA_TTL))
                        }
                    }
                }
            } catch (ex: Exception) {
                emitter.completeWithError(ex)
            }
        }
        return emitter
    }

    @PostMapping
    fun getCryptocurrencies(
        @Valid @RequestBody pageRequestDTO: PageRequestDTO<CryptocurrenciesRequest>
    ): ResponseEntity<CryptocurrenciesResponseDTO> {
        return ResponseEntity.ok(getCryptocurrencies.invoke(pageRequestDTO))
    }

    private fun secondsToMilliseconds(seconds: Long): Long = seconds.times(1000)
}