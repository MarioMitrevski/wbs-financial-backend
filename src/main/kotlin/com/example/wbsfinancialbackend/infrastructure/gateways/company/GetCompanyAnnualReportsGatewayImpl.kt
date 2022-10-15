package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyAnnualReportsGateway
import com.example.wbsfinancialbackend.infrastructure.db.company.financialdata.CompanyFinancialData
import com.example.wbsfinancialbackend.infrastructure.db.company.financialdata.CompanyFinancialDataRepository
import org.springframework.stereotype.Service

@Service
class GetCompanyAnnualReportsGatewayImpl(
    val companyFinancialDataRepository: CompanyFinancialDataRepository
): GetCompanyAnnualReportsGateway {
    override fun findAllByCompanyId(id: Int): List<CompanyFinancialData> {
        return companyFinancialDataRepository.findAllByCompanyId(id)
    }
}