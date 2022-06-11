package com.example.wbsfinancialbackend.domain.company.categories.usecases

import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.db.company.sector.Sector
import com.example.wbsfinancialbackend.db.company.sector.SectorRepository
import java.util.*

@UseCase
class GetCompanySectors(
    val sectorRepository: SectorRepository
) {

    operator fun invoke(): List<String> {
        return sectorRepository.findAll().filter { it.active }.map { it.name }.toList()
    }
}