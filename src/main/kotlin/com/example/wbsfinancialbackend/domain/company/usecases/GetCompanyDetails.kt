package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.FinHubClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyDetailsResponseDTO

@UseCase
class GetCompanyDetails(
    val finHubClient: FinHubClient
) {

    operator fun invoke(symbol: String): CompanyDetailsResponseDTO {
        return finHubClient.getCompanyDetails(symbol)
    }
}