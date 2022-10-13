package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.config.RedisConfig.Companion.COMPANY_ANNUAL_REPORTS_CACHE_VALUE
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.db.company.financialdata.CompanyFinancialData
import com.example.wbsfinancialbackend.db.company.financialdata.CompanyFinancialDataRepository
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetCompanyAnnualReports(
    val companyFinancialDataRepository: CompanyFinancialDataRepository
) {

    @Cacheable(value = [COMPANY_ANNUAL_REPORTS_CACHE_VALUE])
    operator fun invoke(id: Int): List<CompanyFinancialData> {
        return companyFinancialDataRepository.findAllByCompanyId(id)
    }
}