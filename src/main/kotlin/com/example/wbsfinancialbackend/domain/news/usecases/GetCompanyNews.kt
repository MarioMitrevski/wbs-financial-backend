package com.example.wbsfinancialbackend.domain.news.usecases

import com.example.wbsfinancialbackend.datasources.FinHubClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.news.NewsResponseDTO
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@UseCase
class GetCompanyNews(
    val finHubClient: FinHubClient
) {

    operator fun invoke(symbol: String): List<NewsResponseDTO> {
        return finHubClient.getCompanyNews(
            symbol,
            LocalDate.now().minusMonths(6).format(DateTimeFormatter.ISO_DATE),
            LocalDate.now().format(DateTimeFormatter.ISO_DATE)
        )
    }
}