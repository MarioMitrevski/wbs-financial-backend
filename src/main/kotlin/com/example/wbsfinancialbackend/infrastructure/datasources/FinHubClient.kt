package com.example.wbsfinancialbackend.infrastructure.datasources

import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.ClientsEndpoints
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyRecommendationTrendsResponseDTO
import com.example.wbsfinancialbackend.infrastructure.datasources.news.NewsResponseDTO
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    contextId = "finhubContextId",
    value = "finhubclient",
    url = ClientsEndpoints.FIN_HUB,
    configuration = [FinHubClientConfiguration::class]
)
interface FinHubClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/stock/recommendation"], produces = ["application/json"])
    fun getCompanyRecommendationTrends(
        @RequestParam symbol: String
    ): List<CompanyRecommendationTrendsResponseDTO>

    @RequestMapping(method = [RequestMethod.GET], value = ["/company-news"], produces = ["application/json"])
    fun getCompanyNews(
        @RequestParam symbol: String,
        @RequestParam from: String,
        @RequestParam to: String
    ): List<NewsResponseDTO>

    @RequestMapping(method = [RequestMethod.GET], value = ["/news"], produces = ["application/json"])
    fun getNews(
        @RequestParam category: String,
    ): List<NewsResponseDTO>
}

class FinhubClientInterceptor(private val key: String) : RequestInterceptor {
    override fun apply(requestTemplate: RequestTemplate) {
        requestTemplate.query("token", key)
    }
}

class FinHubClientConfiguration(
    private val datasourceProperties: DatasourceProperties
) {

    @Bean
    fun finhubRequestInterceptor(): FinhubClientInterceptor {
        return FinhubClientInterceptor(datasourceProperties.finhubKey)
    }
}