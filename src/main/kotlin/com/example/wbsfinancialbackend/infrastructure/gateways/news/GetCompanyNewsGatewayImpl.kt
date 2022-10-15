package com.example.wbsfinancialbackend.infrastructure.gateways.news

import com.example.wbsfinancialbackend.core.news.gateways.GetCompanyNewsGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.FinHubClient
import com.example.wbsfinancialbackend.infrastructure.datasources.news.NewsResponseDTO
import org.springframework.stereotype.Service

@Service
class GetCompanyNewsGatewayImpl(
    val finHubClient: FinHubClient
) : GetCompanyNewsGateway {
    override fun getCompanyNews(symbol: String, from: String, to: String): List<NewsResponseDTO> {
        return finHubClient.getCompanyNews(symbol, from, to)
    }
}