package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.gateways.SyncCompaniesDataGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.IEXClient
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyDTO
import com.example.wbsfinancialbackend.infrastructure.db.company.Company
import com.example.wbsfinancialbackend.infrastructure.db.company.CompanyRepository
import com.example.wbsfinancialbackend.infrastructure.db.company.sector.Sector
import com.example.wbsfinancialbackend.infrastructure.db.company.sector.SectorRepository
import org.springframework.stereotype.Service

@Service
class SyncCompaniesDataGatewayImpl(
    val iexClient: IEXClient,
    val sectorRepository: SectorRepository,
    val companyRepository: CompanyRepository
) : SyncCompaniesDataGateway {
    override fun getCompaniesBySector(sector: String): List<CompanyDTO> {
        return iexClient.getCompaniesBySector(sector)
    }

    override fun findCompanyBySymbol(symbol: String): Company? {
        return companyRepository.findCompanyBySymbol(symbol).orElse(null)
    }

    override fun findAllByActive(): List<Sector> {
        return sectorRepository.findAllByActive()
    }

    override fun saveCompanies(companies: Set<Company>) {
        companyRepository.saveAll(companies)
    }
}