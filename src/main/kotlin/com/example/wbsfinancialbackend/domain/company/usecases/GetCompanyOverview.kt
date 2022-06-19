package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyOverviewResponseDTO
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.db.company.CompanyRepository

@UseCase
class GetCompanyOverview(
    val companyRepository: CompanyRepository
) {

    operator fun invoke(symbol: String): CompanyOverviewResponseDTO {
        return CompanyOverviewResponseDTO(
            companyRepository.findCompanyBySymbol(symbol)
                .orElseThrow { throw IllegalStateException("Not found symbol") }.description
        )
    }
}