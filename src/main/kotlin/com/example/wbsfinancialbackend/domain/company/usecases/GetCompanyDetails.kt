package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyDetailsResponseDTO
import com.example.wbsfinancialbackend.db.company.CompanyRepository

@UseCase
class GetCompanyDetails(
    val companyRepository: CompanyRepository
) {

    operator fun invoke(symbol: String): CompanyDetailsResponseDTO {
        val company = companyRepository.findCompanyBySymbol(symbol).orElseThrow {
            throw IllegalArgumentException("")
        }
        return CompanyDetailsResponseDTO(
            company.companyName,
            company.symbol,
            company.logo,
            company.sector.name,
            company.website,
            company.country,
            company.exchange ?: "",
            company.ceo,
            company.description,
            company.employees
        )
    }
}