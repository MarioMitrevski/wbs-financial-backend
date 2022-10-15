package com.example.wbsfinancialbackend.infrastructure.gateways.news

import com.example.wbsfinancialbackend.core.news.gateways.GetNewsGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.FinHubClient
import com.example.wbsfinancialbackend.infrastructure.datasources.news.NewsResponseDTO
import org.springframework.stereotype.Service

@Service
class GetNewsGatewayImpl(
    val finHubClient: FinHubClient
): GetNewsGateway {
    override fun getNews(category: String): List<NewsResponseDTO> {
        return finHubClient.getNews(category)
    }
}