package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyLogoDTO
import com.example.wbsfinancialbackend.datasources.IEXClient
import com.example.wbsfinancialbackend.datasources.UseCase

@UseCase
class GetCompanyLogo(
    private val iexClient: IEXClient
) {
    operator fun invoke(symbol: String): CompanyLogoDTO {
        return iexClient.getCompanyLogo(symbol)
    }
}