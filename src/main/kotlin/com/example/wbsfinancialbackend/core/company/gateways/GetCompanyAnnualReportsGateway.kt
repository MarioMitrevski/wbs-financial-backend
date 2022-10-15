package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.core.company.CompanyFinancialDataModel

interface GetCompanyAnnualReportsGateway {
    fun findAllByCompanyId(id: Int): CompanyFinancialDataModel
}