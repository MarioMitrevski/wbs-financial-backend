package com.example.wbsfinancialbackend.datasources

import com.example.wbsfinancialbackend.constants.endpoints.ClientsEndpoints
import com.example.wbsfinancialbackend.datasources.company.CompanyDetailsResponseDTO
import com.example.wbsfinancialbackend.datasources.company.CompanyRecommendationTrendsResponseDTO
import com.example.wbsfinancialbackend.datasources.news.NewsResponseDTO
import com.example.wbsfinancialbackend.domain.company.usecases.SearchCompanyResponseDTO
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    value = "finhubclient",
    url = ClientsEndpoints.FIN_HUB,
    configuration = [FinHubClientConfiguration::class]
)
interface FinHubClient {
    @RequestMapping(method = [RequestMethod.GET], value = ["/stock/profile2"], produces = ["application/json"])
    fun getCompanyDetails(
        @RequestParam symbol: String
    ): CompanyDetailsResponseDTO

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

    @RequestMapping(method = [RequestMethod.GET], value = ["/search"], produces = ["application/json"])
    fun searchCompany(
        @RequestParam q: String,
    ): SearchCompanyResponseDTO
}

@Configuration
class FinHubClientConfiguration {

    val finHubKey: String? = System.getenv("finhub_key")

    @Bean
    fun finHubRequestInterceptor(): RequestInterceptor? {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            if (requestTemplate.feignTarget().type() == FinHubClient::class.java) {
                requestTemplate.query("token", "ca5uunaad3ib7i7rrp40")
            }
        }
    }
}