package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.AlphaVantageClient
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyOverviewResponseDTO
import com.example.wbsfinancialbackend.datasources.UseCase

@UseCase
class GetCompanyOverview(
    val alphaVantageClient: AlphaVantageClient
) {

    operator fun invoke(symbol: String): CompanyOverviewResponseDTO {
        return alphaVantageClient.getCompanyOverview(symbol)
    }
}