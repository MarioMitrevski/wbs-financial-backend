package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.AlphaVantageClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.CompanyEarningsResponseDTO

@UseCase
class GetCompanyEarningsPerShare(
    val alphaVantageClient: AlphaVantageClient
) {

    operator fun invoke(
        symbol: String
    ): CompanyEarningsResponseDTO {
        return alphaVantageClient.getCompanyEarningsPerShare(symbol)
    }
}