package com.example.wbsfinancialbackend.datasources

import com.example.wbsfinancialbackend.constants.endpoints.ClientsEndpoints
import com.example.wbsfinancialbackend.datasources.company.dtos.*
import com.example.wbsfinancialbackend.db.company.Company
import feign.Logger
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    contextId = "iexContextId",
    value = "iexclient",
    url = ClientsEndpoints.IEX,
    configuration = [IexClientConfiguration::class]
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

class IexClientInterceptor(private val key: String) : RequestInterceptor {
    override fun apply(requestTemplate: RequestTemplate) {
        requestTemplate.query("token", key)
    }
}

class IexClientConfiguration(
    private val datasourceProperties: DatasourceProperties
) {

    @Bean
    fun iexClientRequestInterceptor(): IexClientInterceptor {
        return IexClientInterceptor(datasourceProperties.iexKey)
    }

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }
}