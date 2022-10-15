package com.example.wbsfinancialbackend.core.company.usecases

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyLogoGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyLogoDTO

@UseCase
class GetCompanyLogo(
    private val getCompanyLogoGateway: GetCompanyLogoGateway
) {
    operator fun invoke(symbol: String): CompanyLogoDTO {
        return getCompanyLogoGateway.getCompanyLogo(symbol)
    }
}