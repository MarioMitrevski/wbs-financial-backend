package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.FinHubClient
import com.example.wbsfinancialbackend.datasources.UseCase

@UseCase
class SearchCompany(
    val finHubClient: FinHubClient
) {

    operator fun invoke(query: String): SearchCompanyResponseDTO {
        return finHubClient.searchCompany(query)
    }
}