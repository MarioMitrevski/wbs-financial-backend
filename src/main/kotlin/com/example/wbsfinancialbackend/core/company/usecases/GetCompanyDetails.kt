package com.example.wbsfinancialbackend.core.company.usecases

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyDetailsGateway
import com.example.wbsfinancialbackend.infrastructure.config.RedisConfig.Companion.COMPANY_DETAILS_CACHE_VALUE
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyDetailsResponseDTO
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.mapToCompanyDetailsResponseDTO
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetCompanyDetails(
    val getCompanyDetailsGateway: GetCompanyDetailsGateway
) {

    @Cacheable(value = [COMPANY_DETAILS_CACHE_VALUE])
    operator fun invoke(symbol: String): CompanyDetailsResponseDTO {
        val company = getCompanyDetailsGateway.findCompanyBySymbol(symbol)
        return company.mapToCompanyDetailsResponseDTO()
    }
}