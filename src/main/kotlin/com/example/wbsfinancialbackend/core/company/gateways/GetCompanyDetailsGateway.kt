package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.infrastructure.db.company.Company

interface GetCompanyDetailsGateway {
    fun findCompanyBySymbol(symbol: String): Company
}