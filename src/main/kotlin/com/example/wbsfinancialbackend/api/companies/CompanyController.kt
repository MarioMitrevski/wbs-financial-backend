package com.example.wbsfinancialbackend.api.companies

import com.example.wbsfinancialbackend.api.PageRequestDTO
import com.example.wbsfinancialbackend.api.PaginationResponseDTO
import com.example.wbsfinancialbackend.api.companies.dtos.CompaniesRequestDTO
import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.datasources.CompanyLogoDTO
import com.example.wbsfinancialbackend.datasources.company.dtos.*
import com.example.wbsfinancialbackend.datasources.news.NewsResponseDTO
import com.example.wbsfinancialbackend.domain.company.usecases.*
import com.example.wbsfinancialbackend.domain.news.usecases.GetCompanyNews
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.COMPANY_ENDPOINT])
class CompanyController(
    val companyService: CompanyService,
    val getCompanyOverview: GetCompanyOverview,
    val getCompanyEarningsPerShare: GetCompanyEarningsPerShare,
    val getCompanyAnnualReports: GetCompanyAnnualReports,
    val getCompanyDetails: GetCompanyDetails,
    val getCompanyRecommendationTrends: GetCompanyRecommendationTrends,
    val getCompanyNews: GetCompanyNews,
    val getCompanies: GetCompanies,
    val getCompanyLogo: GetCompanyLogo
) {

    @GetMapping(path = ["/{name}/wikiLinks"])
    fun getCompanyWikiLinks(
        @PathVariable name: String,
        @RequestParam(name = "predicate") predicate: String
    ): List<String> {
        return companyService.getCompanyWikiLinks(name, predicate)
    }

    @GetMapping(path = ["/{symbol}/overview"])
    fun getCompanyOverview(@PathVariable("symbol") symbol: String): ResponseEntity<CompanyOverviewResponseDTO> {
        return ResponseEntity.ok(getCompanyOverview.invoke(symbol))
    }

    @GetMapping(path = ["/{symbol}/earnings"])
    fun getCompanyEarningsAnnual(
        @PathVariable("symbol") symbol: String,
    ): ResponseEntity<CompanyEarningsResponseDTO> {
        return ResponseEntity.ok(getCompanyEarningsPerShare.invoke(symbol))
    }

    @GetMapping(path = ["/{symbol}/annualReports"])
    fun getCompanyReportsAnnual(
        @PathVariable("symbol") symbol: String,
    ): ResponseEntity<CompanyAnnualReportsDTO> {
        return ResponseEntity.ok(getCompanyAnnualReports.invoke(symbol))
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
        @RequestBody companiesRequestDTO: CompaniesRequestDTO
    ): ResponseEntity<CompaniesBasicInfoDTO> {
        val companies =
            getCompanies.invoke(
                companiesRequestDTO.pageRequest ?: PageRequestDTO(0, 10),
                companiesRequestDTO.sector,
                companiesRequestDTO.query
            )
        return ResponseEntity.ok(
            CompaniesBasicInfoDTO(
                PaginationResponseDTO(companies.number, companies.totalElements, companies.totalPages, companies.hasNext(), companies.hasPrevious()),
                companies.get().map { CompanyBasicInfoDTO(it.companyName, it.symbol, it.exchange ?: "", it.logoUrl) }
                    .toList()
            )
        )
    }

    @GetMapping("/{symbol}/logo")
    fun getCompanyLogo(
        @PathVariable symbol: String
    ): ResponseEntity<CompanyLogoDTO> {
        return ResponseEntity.ok(getCompanyLogo.invoke(symbol))
    }
}