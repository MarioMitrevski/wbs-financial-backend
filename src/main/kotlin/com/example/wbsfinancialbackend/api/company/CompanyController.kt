package com.example.wbsfinancialbackend.api.company

import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.datasources.company.CompanyAnnualReportDTO
import com.example.wbsfinancialbackend.datasources.company.CompanyAnnualReportsDTO
import com.example.wbsfinancialbackend.datasources.company.CompanyEarningsResponseDTO
import com.example.wbsfinancialbackend.datasources.company.CompanyOverviewResponseDTO
import com.example.wbsfinancialbackend.domain.company.usecases.GetCompanyAnnualReports
import com.example.wbsfinancialbackend.domain.company.usecases.GetCompanyDetails
import com.example.wbsfinancialbackend.domain.company.usecases.GetCompanyEarningsPerShare
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.COMPANY_ENDPOINT])
class CompanyController(
    val companyService: CompanyService,
    val getCompanyDetails: GetCompanyDetails,
    val getCompanyEarningsPerShare: GetCompanyEarningsPerShare,
    val getCompanyAnnualReports: GetCompanyAnnualReports
) {

    @GetMapping(path = ["/{name}/wikiLinks"])
    fun getCompanyWikiLinks(
        @PathVariable name: String,
        @RequestParam(name = "predicate") predicate: String
    ): List<String> {
        return companyService.getCompanyWikiLinks(name, predicate)
    }

    @GetMapping(path = ["/{symbol}/details"])
    fun getCompanyDetails(@PathVariable("symbol") symbol: String): ResponseEntity<CompanyOverviewResponseDTO> {
        return ResponseEntity.ok(getCompanyDetails.invoke(symbol))
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
}