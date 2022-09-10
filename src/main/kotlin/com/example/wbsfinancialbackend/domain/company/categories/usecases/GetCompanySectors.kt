package com.example.wbsfinancialbackend.domain.company.categories.usecases

import com.example.wbsfinancialbackend.config.RedisConfig.Companion.COMPANY_SECTORS_CACHE_VALUE
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.db.company.sector.SectorRepository
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetCompanySectors(
    val sectorRepository: SectorRepository
) {

    @Cacheable(value = [COMPANY_SECTORS_CACHE_VALUE])
    operator fun invoke(): List<String> {
        return sectorRepository.findAllByActive().map { it.name }.toList()
    }
}