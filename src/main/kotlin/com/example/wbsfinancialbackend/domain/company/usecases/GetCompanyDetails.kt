package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.config.RedisConfig.Companion.COMPANY_DETAILS_CACHE_VALUE
import com.example.wbsfinancialbackend.constants.ErrorMessages
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyDetailsResponseDTO
import com.example.wbsfinancialbackend.db.company.Company
import com.example.wbsfinancialbackend.db.company.CompanyRepository
import com.example.wbsfinancialbackend.exceptions.NotFoundException
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetCompanyDetails(
    val companyRepository: CompanyRepository
) {

    @Cacheable(value = [COMPANY_DETAILS_CACHE_VALUE])
    operator fun invoke(symbol: String): CompanyDetailsResponseDTO {
        val company = companyRepository.findCompanyBySymbol(symbol).orElseThrow {
            throw NotFoundException(ErrorMessages.entityNotFoundMessage(Company::class.java.simpleName, symbol))
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