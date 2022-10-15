package com.example.wbsfinancialbackend.core.company.usecases

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyRecommendationTrendsGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyRecommendationTrendsResponseDTO

@UseCase
class GetCompanyRecommendationTrends(
    val getCompanyRecommendationTrendsGateway: GetCompanyRecommendationTrendsGateway
) {

    operator fun invoke(symbol: String): List<CompanyRecommendationTrendsResponseDTO> {
        return getCompanyRecommendationTrendsGateway.getCompanyRecommendationTrends(symbol)
    }
}