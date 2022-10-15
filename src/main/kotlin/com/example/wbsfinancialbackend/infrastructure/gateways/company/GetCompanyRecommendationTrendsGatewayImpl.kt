package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyRecommendationTrendsGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.FinHubClient
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyRecommendationTrendsResponseDTO
import org.springframework.stereotype.Service

@Service
class GetCompanyRecommendationTrendsGatewayImpl(
    val finHubClient: FinHubClient
) : GetCompanyRecommendationTrendsGateway {
    override fun getCompanyRecommendationTrends(symbol: String): List<CompanyRecommendationTrendsResponseDTO> {
        return finHubClient.getCompanyRecommendationTrends(symbol)
    }
}