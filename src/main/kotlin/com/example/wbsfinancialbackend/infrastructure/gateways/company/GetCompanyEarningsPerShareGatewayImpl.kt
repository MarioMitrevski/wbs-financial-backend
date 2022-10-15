package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyEarningsPerShareGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.AlphaVantageClient
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyEarningsResponseDTO
import org.springframework.stereotype.Service

@Service
class GetCompanyEarningsPerShareGatewayImpl(
    val alphaVantageClient: AlphaVantageClient
): GetCompanyEarningsPerShareGateway {
    override fun getCompanyEarningsPerShare(symbol: String): CompanyEarningsResponseDTO {
        return alphaVantageClient.getCompanyEarningsPerShare(symbol)
    }
}