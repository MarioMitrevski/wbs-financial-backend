package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyEarningsResponseDTO

interface GetCompanyEarningsPerShareGateway {
    fun getCompanyEarningsPerShare(symbol: String): CompanyEarningsResponseDTO
}