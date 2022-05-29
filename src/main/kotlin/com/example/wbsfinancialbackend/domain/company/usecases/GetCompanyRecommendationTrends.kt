package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.FinHubClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyRecommendationTrendsResponseDTO


@UseCase
class GetCompanyRecommendationTrends(
    val finHubClient: FinHubClient
) {

    operator fun invoke(symbol: String): List<CompanyRecommendationTrendsResponseDTO> {
        return finHubClient.getCompanyRecommendationTrends(symbol)
    }
}