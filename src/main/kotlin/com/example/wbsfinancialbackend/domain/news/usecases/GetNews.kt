package com.example.wbsfinancialbackend.domain.news.usecases

import com.example.wbsfinancialbackend.constants.ErrorMessages
import com.example.wbsfinancialbackend.datasources.FinHubClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.news.NewsResponseDTO
import com.example.wbsfinancialbackend.enums.NewsCategory
import com.example.wbsfinancialbackend.exceptions.NotFoundException

@UseCase
class GetNews(
    val finHubClient: FinHubClient
) {

    operator fun invoke(category: String): List<NewsResponseDTO> {
        validateNewsCategory(category)
        return finHubClient.getNews(category)
    }

    private fun validateNewsCategory(category: String) {
        if (NewsCategory.values().map { it.value }.find { category == it }.isNullOrEmpty()) {
            throw NotFoundException(ErrorMessages.entityNotFoundMessage(NewsCategory::class.java.simpleName))
        }
    }
}