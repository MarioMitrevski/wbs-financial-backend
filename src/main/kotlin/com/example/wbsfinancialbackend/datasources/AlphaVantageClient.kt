package com.example.wbsfinancialbackend.datasources

import com.example.wbsfinancialbackend.constants.endpoints.ClientsEndpoints.Companion.ALPHA_VANTAGE
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyAnnualReportsDTO
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyEarningsResponseDTO
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
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

    @RequestMapping(method = [RequestMethod.GET], value = ["/query"], produces = ["application/json"])
    fun getCompanyAnnualReports(
        @RequestParam symbol: String,
        @RequestParam function: String = "INCOME_STATEMENT"
    ): CompanyAnnualReportsDTO
}

class AlphaVantageClientInterceptor(private val key: String) : RequestInterceptor {
    override fun apply(requestTemplate: RequestTemplate) {
        requestTemplate.query("apikey", key)
    }
}

@Configuration
class AlphaVantageClientConfiguration(
    val datasourceProperties: DatasourceProperties
) {

    @Bean
    fun alphaVantageRequestInterceptor(): AlphaVantageClientInterceptor {
        return AlphaVantageClientInterceptor(datasourceProperties.alphavantageKey)
    }
}