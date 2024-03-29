package com.example.wbsfinancialbackend.infrastructure.datasources

import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.ClientsEndpoints.Companion.ALPHA_VANTAGE
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyEarningsResponseDTO
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    contextId = "alphavantageContextId",
    value = "alphavantageclient",
    url = ALPHA_VANTAGE,
    configuration = [AlphaVantageClientConfiguration::class]
)
interface AlphaVantageClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/query"], produces = ["application/json"])
    fun getCompanyEarningsPerShare(
        @RequestParam symbol: String,
        @RequestParam function: String = "EARNINGS"
    ): CompanyEarningsResponseDTO

}

class AlphaVantageClientInterceptor(private val key: String) : RequestInterceptor {
    override fun apply(requestTemplate: RequestTemplate) {
        requestTemplate.query("apikey", key)
    }
}

class AlphaVantageClientConfiguration(
    private val datasourceProperties: DatasourceProperties
) {

    @Bean
    fun alphaVantageRequestInterceptor(): AlphaVantageClientInterceptor {
        return AlphaVantageClientInterceptor(
            datasourceProperties.alphavantageKey
        )
    }
}