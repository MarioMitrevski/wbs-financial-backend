package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.CompanyModel
import com.example.wbsfinancialbackend.core.company.categories.SectorModel
import com.example.wbsfinancialbackend.core.company.gateways.SyncCompaniesDataGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.IEXClient
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyDTO
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.mapToCompanyModel
import com.example.wbsfinancialbackend.infrastructure.db.company.CompanyRepository
import com.example.wbsfinancialbackend.infrastructure.db.company.mapToCompany
import com.example.wbsfinancialbackend.infrastructure.db.company.sector.SectorRepository
import com.example.wbsfinancialbackend.infrastructure.db.company.sector.mapToSectorModel
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

    override fun getCompanyDetails(symbol: String): CompanyModel {
        return iexClient.getCompanyDetails(symbol).mapToCompanyModel()
    }

    override fun findAllByActive(): List<SectorModel> {
        return sectorRepository.findAllByActive().map { it.mapToSectorModel() }
    }

    override fun saveCompanies(companies: Set<CompanyModel>) {
        companyRepository.saveAll(companies.map { it.mapToCompany() })
    }
}