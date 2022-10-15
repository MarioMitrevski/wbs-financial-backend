package com.example.wbsfinancialbackend.infrastructure.gateways.company.categories

import com.example.wbsfinancialbackend.core.company.categories.gateways.GetCompanySectorsGateway
import com.example.wbsfinancialbackend.infrastructure.db.company.sector.Sector
import com.example.wbsfinancialbackend.infrastructure.db.company.sector.SectorRepository
import org.springframework.stereotype.Service

@Service
class GetCompanySectorsGatewayImpl(
    val sectorRepository: SectorRepository
) : GetCompanySectorsGateway {
    override fun findAllByActive(): List<Sector> {
        return sectorRepository.findAllByActive()
    }
}