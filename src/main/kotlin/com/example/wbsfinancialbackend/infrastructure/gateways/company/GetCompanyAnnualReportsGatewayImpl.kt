package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.CompanyFinancialDataModel
import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyAnnualReportsGateway
import com.example.wbsfinancialbackend.infrastructure.db.company.financialdata.CompanyFinancialDataRepository
import com.example.wbsfinancialbackend.infrastructure.db.company.financialdata.mapToCompanyFinancialDataModel
import com.example.wbsfinancialbackend.infrastructure.exceptions.NotFoundException
import org.springframework.stereotype.Service
import java.time.Year

@Service
class GetCompanyAnnualReportsGatewayImpl(
    val companyFinancialDataRepository: CompanyFinancialDataRepository
) : GetCompanyAnnualReportsGateway {
    override fun findAllByCompanyId(id: Int): CompanyFinancialDataModel {
        return companyFinancialDataRepository.findByCompanyIdAndFiscalYear(id, Year.now().minusYears(1).toString())
            .orElseThrow { throw NotFoundException(null) }
            .mapToCompanyFinancialDataModel()
    }
}