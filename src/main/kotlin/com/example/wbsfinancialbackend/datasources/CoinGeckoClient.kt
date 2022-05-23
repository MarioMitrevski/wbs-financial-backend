package com.example.wbsfinancialbackend.datasources

import com.example.wbsfinancialbackend.constants.endpoints.ClientsEndpoints
import org.springframework.cloud.openfeign.FeignClient

@FeignClient(
    value = "coingeckoclient",
    url = ClientsEndpoints.ALPHA_VANTAGE,
    configuration = [AlphaVantageClientConfiguration::class]
)
class CoinGeckoClient {
}