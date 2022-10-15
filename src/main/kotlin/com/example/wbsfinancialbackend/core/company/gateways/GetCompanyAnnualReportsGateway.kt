package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.infrastructure.db.company.financialdata.CompanyFinancialData

interface GetCompanyAnnualReportsGateway {
    fun findAllByCompanyId(id: Int): List<CompanyFinancialData>
}