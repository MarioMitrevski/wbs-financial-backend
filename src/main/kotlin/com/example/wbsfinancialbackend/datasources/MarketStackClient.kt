package com.example.wbsfinancialbackend.datasources

import com.example.wbsfinancialbackend.constants.endpoints.ClientsEndpoints
import com.example.wbsfinancialbackend.datasources.company.stockexchanges.StockExchangesResponseDTO
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    value = "marketstacklient",
    url = ClientsEndpoints.MARKET_STACK,
    configuration = [MarketStackClientConfiguration::class]
)
interface MarketStackClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/exchanges"], produces = ["application/json"])
    fun getExchanges(
        @RequestParam offset: Int,
        @RequestParam limit: Int,
        @RequestParam search: String
    ): StockExchangesResponseDTO
}


class MarketStackClientInterceptor(private val key: String) : RequestInterceptor {
    override fun apply(requestTemplate: RequestTemplate) {
        requestTemplate.query("access_key", key)
    }
}

@Configuration
class MarketStackClientConfiguration(
    val datasourceProperties: DatasourceProperties
) {

    @Bean
    fun marketStackRequestInterceptor(): MarketStackClientInterceptor {
        return MarketStackClientInterceptor(datasourceProperties.marketstackKey)
    }
}