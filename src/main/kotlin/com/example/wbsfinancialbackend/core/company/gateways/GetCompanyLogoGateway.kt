package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyLogoDTO

interface GetCompanyLogoGateway {
    fun getCompanyLogo(symbol: String): CompanyLogoDTO
}