package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyLogoGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.IEXClient
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyLogoDTO
import org.springframework.stereotype.Service

@Service
class GetCompanyLogoGatewayImpl(
    private val iexClient: IEXClient
): GetCompanyLogoGateway {
    override fun getCompanyLogo(symbol: String): CompanyLogoDTO {
        return iexClient.getCompanyLogo(symbol)
    }
}