package com.example.wbsfinancialbackend.domain.news.usecases

import com.example.wbsfinancialbackend.datasources.FinHubClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.news.NewsResponseDTO
import com.example.wbsfinancialbackend.enums.NewsCategory

@UseCase
class GetNews(
    val finHubClient: FinHubClient
) {

    operator fun invoke(category: String): List<NewsResponseDTO> {
        if (NewsCategory.values().map { it.value }.find { category == it }.isNullOrEmpty()) {
            throw IllegalArgumentException("Not supported news category!")
        }
        return finHubClient.getNews(category)
    }
}