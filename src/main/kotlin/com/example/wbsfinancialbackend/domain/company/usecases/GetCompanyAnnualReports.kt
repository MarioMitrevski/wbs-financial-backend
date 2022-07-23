package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.config.RedisConfig.Companion.COMPANY_ANNUAL_REPORTS_CACHE_VALUE
import com.example.wbsfinancialbackend.datasources.AlphaVantageClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyAnnualReportsDTO
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetCompanyAnnualReports(
    val alphaVantageClient: AlphaVantageClient
) {

    @Cacheable(value = [COMPANY_ANNUAL_REPORTS_CACHE_VALUE])
    operator fun invoke(symbol: String): CompanyAnnualReportsDTO {
        return alphaVantageClient.getCompanyAnnualReports(symbol)
    }
}