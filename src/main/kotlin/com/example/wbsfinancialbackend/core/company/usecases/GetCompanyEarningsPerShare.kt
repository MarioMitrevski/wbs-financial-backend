package com.example.wbsfinancialbackend.core.company.usecases

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyEarningsPerShareGateway
import com.example.wbsfinancialbackend.infrastructure.config.RedisConfig.Companion.COMPANY_EARNINGS_CACHE_VALUE
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyEarningsResponseDTO
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetCompanyEarningsPerShare(
    val getCompanyEarningsPerShareGateway: GetCompanyEarningsPerShareGateway
) {

    @Cacheable(value = [COMPANY_EARNINGS_CACHE_VALUE])
    operator fun invoke(
        symbol: String
    ): CompanyEarningsResponseDTO {
        return getCompanyEarningsPerShareGateway.getCompanyEarningsPerShare(symbol)
    }
}