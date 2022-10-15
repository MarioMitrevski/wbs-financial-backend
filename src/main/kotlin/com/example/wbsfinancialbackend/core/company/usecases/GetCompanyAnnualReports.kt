package com.example.wbsfinancialbackend.core.company.usecases

import com.example.wbsfinancialbackend.core.company.CompanyFinancialDataModel
import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyAnnualReportsGateway
import com.example.wbsfinancialbackend.infrastructure.config.RedisConfig.Companion.COMPANY_ANNUAL_REPORTS_CACHE_VALUE
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetCompanyAnnualReports(
    val getCompanyAnnualReportsGateway: GetCompanyAnnualReportsGateway
) {

    @Cacheable(value = [COMPANY_ANNUAL_REPORTS_CACHE_VALUE])
    operator fun invoke(id: Int): CompanyFinancialDataModel {
        return getCompanyAnnualReportsGateway.findAllByCompanyId(id)
    }
}