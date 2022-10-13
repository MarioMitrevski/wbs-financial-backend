package com.example.wbsfinancialbackend.api.companies

import com.example.wbsfinancialbackend.api.PageRequestDTO
import com.example.wbsfinancialbackend.api.PaginationResponseDTO
import com.example.wbsfinancialbackend.api.companies.dtos.CompaniesRequest
import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.datasources.company.dtos.*
import com.example.wbsfinancialbackend.datasources.news.NewsResponseDTO
import com.example.wbsfinancialbackend.db.company.financialdata.CompanyFinancialData
import com.example.wbsfinancialbackend.domain.company.usecases.*
import com.example.wbsfinancialbackend.domain.news.usecases.GetCompanyNews
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.COMPANY_ENDPOINT])
class CompanyController(
    val companyService: CompanyService,
    val getCompanyEarningsPerShare: GetCompanyEarningsPerShare,
    val getCompanyAnnualReports: GetCompanyAnnualReports,
    val getCompanyDetails: GetCompanyDetails,
    val getCompanyRecommendationTrends: GetCompanyRecommendationTrends,
    val getCompanyNews: GetCompanyNews,
    val getCompanies: GetCompanies,
    val getCompanyHistoricalPrices: GetCompanyHistoricalPrices
) {

    @GetMapping(path = ["/{name}/wikiLinks"])
    fun getCompanyWikiLinks(
        @PathVariable name: String,
        @RequestParam(name = "predicate") predicate: String
    ): List<String> {
        return companyService.getCompanyWikiLinks(name, predicate)
    }

    @GetMapping(path = ["/{symbol}/earnings"])
    fun getCompanyEarningsAnnual(
        @PathVariable("symbol") symbol: String,
    ): ResponseEntity<CompanyEarningsResponseDTO> {
        return ResponseEntity.ok(getCompanyEarningsPerShare.invoke(symbol))
    }

    @GetMapping(path = ["/{id}/annualReports"])
    fun getCompanyReportsAnnual(
        @PathVariable("id") id: Int,
    ): ResponseEntity<List<CompanyFinancialData>> {
        return ResponseEntity.ok(getCompanyAnnualReports.invoke(id))
    }

    @GetMapping(path = ["/{symbol}/details"])
    fun getCompanyDetails(
        @PathVariable("symbol") symbol: String,
    ): ResponseEntity<CompanyDetailsResponseDTO> {
        return ResponseEntity.ok(getCompanyDetails.invoke(symbol))
    }

    @GetMapping(path = ["/{symbol}/recommendation"])
    fun getCompanyRecommendationTrends(
        @PathVariable("symbol") symbol: String,
    ): ResponseEntity<List<CompanyRecommendationTrendsResponseDTO>> {
        return ResponseEntity.ok(getCompanyRecommendationTrends.invoke(symbol))
    }

    @GetMapping(path = ["/{symbol}/news"])
    fun getCompanyNews(
        @PathVariable("symbol") symbol: String,
    ): ResponseEntity<List<NewsResponseDTO>> {
        return ResponseEntity.ok(getCompanyNews.invoke(symbol))
    }

    @PostMapping
    fun getCompanies(
        @Valid @RequestBody pageRequestDTO: PageRequestDTO<CompaniesRequest>
    ): ResponseEntity<CompaniesBasicInfoDTO> {
        val companies = getCompanies.invoke(pageRequestDTO)
        return ResponseEntity.ok(
            CompaniesBasicInfoDTO(
                PaginationResponseDTO(
                    companies.number,
                    companies.totalElements,
                    companies.totalPages,
                    companies.hasNext(),
                    companies.hasPrevious()
                ),
                companies.get().map { it.mapToCompanyBasicInfoDTO() }.toList()
            )
        )
    }

    @GetMapping("/{symbol}/historicalPrices")
    fun getCompanyHistoricalPrices(
        @PathVariable symbol: String,
        @RequestParam range: String,
        @RequestParam(defaultValue = "true") chartCloseOnly: Boolean
    ): ResponseEntity<List<CompanyPriceDTO>> {
        return ResponseEntity.ok(getCompanyHistoricalPrices.invoke(symbol, range, chartCloseOnly))
    }
}