package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.core.company.CompanyModel

interface GetCompanyDetailsGateway {
    fun findCompanyBySymbol(symbol: String): CompanyModel
}