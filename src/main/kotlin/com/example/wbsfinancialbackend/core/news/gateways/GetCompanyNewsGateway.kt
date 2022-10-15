package com.example.wbsfinancialbackend.core.news.gateways

import com.example.wbsfinancialbackend.infrastructure.datasources.news.NewsResponseDTO

interface GetCompanyNewsGateway {
    fun getCompanyNews(
        symbol: String,
        from: String,
        to: String
    ): List<NewsResponseDTO>
}