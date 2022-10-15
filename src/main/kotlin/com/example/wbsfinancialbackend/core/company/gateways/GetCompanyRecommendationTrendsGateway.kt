package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyRecommendationTrendsResponseDTO

interface GetCompanyRecommendationTrendsGateway {
    fun getCompanyRecommendationTrends(symbol: String): List<CompanyRecommendationTrendsResponseDTO>
}