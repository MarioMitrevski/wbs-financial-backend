package com.example.wbsfinancialbackend.core.news.gateways

import com.example.wbsfinancialbackend.infrastructure.datasources.news.NewsResponseDTO

interface GetNewsGateway {
    fun getNews(category: String): List<NewsResponseDTO>
}