package com.example.wbsfinancialbackend.datasources

import com.example.wbsfinancialbackend.constants.endpoints.ClientsEndpoints.Companion.ALPHA_VANTAGE
import com.example.wbsfinancialbackend.datasources.company.CompanyAnnualReportsDTO
import com.example.wbsfinancialbackend.datasources.company.CompanyEarningsResponseDTO
import com.example.wbsfinancialbackend.datasources.company.CompanyOverviewResponseDTO
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
    fun getCompanyOverview(
        @RequestParam symbol: String,
        @RequestParam function: String = "OVERVIEW"
    ): CompanyOverviewResponseDTO

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

@Configuration
class AlphaVantageClientConfiguration {

    val alphaVantageKey: String? = System.getenv("alpha_vantage_key")

    @Bean
    fun requestInterceptor(): RequestInterceptor? {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            if (requestTemplate.feignTarget().type() == AlphaVantageClient::class.java) {
                requestTemplate.query("apikey", alphaVantageKey)
            }
        }
    }
}