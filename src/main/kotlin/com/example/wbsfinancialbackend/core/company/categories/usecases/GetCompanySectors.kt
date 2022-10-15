package com.example.wbsfinancialbackend.core.company.categories.usecases

import com.example.wbsfinancialbackend.core.company.categories.gateways.GetCompanySectorsGateway
import com.example.wbsfinancialbackend.infrastructure.config.RedisConfig.Companion.COMPANY_SECTORS_CACHE_VALUE
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetCompanySectors(
    val getCompanySectorsGateway: GetCompanySectorsGateway
) {

    @Cacheable(value = [COMPANY_SECTORS_CACHE_VALUE])
    operator fun invoke(): List<String> {
        return getCompanySectorsGateway.findAllByActive().map { it.name }.toList()
    }
}