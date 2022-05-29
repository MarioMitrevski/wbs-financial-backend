package com.example.wbsfinancialbackend.datasources

import com.example.wbsfinancialbackend.constants.endpoints.ClientsEndpoints
import com.example.wbsfinancialbackend.datasources.company.dtos.CompaniesBasicInfoDTO
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


@Configuration
class MarketStackClientConfiguration {

    val marketStackKey: String? = System.getenv("market_stack_key")

    @Bean
    fun marketStackRequestInterceptor(): RequestInterceptor? {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            if (requestTemplate.feignTarget().type() == MarketStackClient::class.java) {
                requestTemplate.query("access_key", marketStackKey)
            }
        }
    }
}