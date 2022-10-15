package com.example.wbsfinancialbackend.core.news.usecases

import com.example.wbsfinancialbackend.core.news.gateways.GetCompanyNewsGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.news.NewsResponseDTO
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@UseCase
class GetCompanyNews(
    val getCompanyNewsGateway: GetCompanyNewsGateway
) {

    operator fun invoke(symbol: String): List<NewsResponseDTO> {
        return getCompanyNewsGateway.getCompanyNews(
            symbol,
            LocalDate.now().minusMonths(6).format(DateTimeFormatter.ISO_DATE),
            LocalDate.now().format(DateTimeFormatter.ISO_DATE)
        )
    }
}