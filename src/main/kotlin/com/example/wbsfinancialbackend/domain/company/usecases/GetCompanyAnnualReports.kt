package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.AlphaVantageClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.CompanyAnnualReportsDTO

@UseCase
class GetCompanyAnnualReports(
    val alphaVantageClient: AlphaVantageClient
) {

    operator fun invoke(symbol: String): CompanyAnnualReportsDTO {
        return alphaVantageClient.getCompanyAnnualReports(symbol)
    }
}