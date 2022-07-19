package com.example.wbsfinancialbackend.datasources

import com.example.wbsfinancialbackend.constants.endpoints.ClientsEndpoints
import com.example.wbsfinancialbackend.datasources.company.dtos.*
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    value = "iexclient",
    url = ClientsEndpoints.IEX,
    configuration = [IEXClientConfiguration::class]
)
interface IEXClient {

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/stock/{symbol}/chart/{range}"],
        produces = ["application/json"]
    )
    fun getHistoricalPrices(
        @PathVariable symbol: String,
        @PathVariable range: String,
        @RequestParam chartCloseOnly: Boolean
    ): List<CompanyPriceDTO>

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/stock/market/list/gainers"],
        produces = ["application/json"]
    )
    fun getMarketTopGainers(): List<MarketTopStocksDTO>

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/stock/market/list/losers"],
        produces = ["application/json"]
    )
    fun getMarketTopLosers(
    ): List<MarketTopStocksDTO>

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/stock/{symbol}/logo"],
        produces = ["application/json"]
    )
    fun getCompanyLogo(
        @PathVariable symbol: String
    ): CompanyLogoDTO

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/stock/{symbol}/company"],
        produces = ["application/json"]
    )
    fun getCompanyDetails(
        @PathVariable symbol: String
    ): CompanyDetailsResponseDTO

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/stock/market/collection/sector"],
        produces = ["application/json"]
    )
    fun getCompaniesBySector(
        @RequestParam collectionName: String
    ): List<CompanyDTO>
}

@Configuration
class IEXClientConfiguration {

    val iexKey: String? = System.getenv("iex_key")

    @Bean
    fun iexRequestInterceptor(): RequestInterceptor? {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            if (requestTemplate.feignTarget().type() == IEXClient::class.java) {
                requestTemplate.query("token", iexKey)
            }
        }
    }
}