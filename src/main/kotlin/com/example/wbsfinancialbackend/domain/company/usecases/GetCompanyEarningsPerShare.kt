package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.config.RedisConfig.Companion.COMPANY_EARNINGS_CACHE_VALUE
import com.example.wbsfinancialbackend.datasources.AlphaVantageClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyEarningsResponseDTO
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetCompanyEarningsPerShare(
    val alphaVantageClient: AlphaVantageClient
) {

    @Cacheable(value = [COMPANY_EARNINGS_CACHE_VALUE])
    operator fun invoke(
        symbol: String
    ): CompanyEarningsResponseDTO {
        return alphaVantageClient.getCompanyEarningsPerShare(symbol)
    }
}