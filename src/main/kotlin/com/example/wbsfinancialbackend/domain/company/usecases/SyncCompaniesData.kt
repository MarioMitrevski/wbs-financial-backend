package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.CompanyLogoDTO
import com.example.wbsfinancialbackend.datasources.IEXClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.db.company.Company
import com.example.wbsfinancialbackend.db.company.CompanyRepository
import com.example.wbsfinancialbackend.db.sector.SectorRepository

@UseCase
class SyncCompaniesData(
    val iexClient: IEXClient,
    val sectorRepository: SectorRepository,
    val companyRepository: CompanyRepository
) {

    operator fun invoke() {
        val companies: MutableSet<Company> = mutableSetOf()

        sectorRepository.findAll()
            .forEach { sector ->
                val companiesDTOInSector = iexClient.getCompaniesBySector(sector.name)
                val companiesWithLogo = if (companiesDTOInSector.isNotEmpty()) {
                    companiesDTOInSector.subList(0,1).map {
                        var logo = CompanyLogoDTO("")
                        try {
                            logo =
                                iexClient.getCompanyLogo(it.symbol)
                        } catch (_: Exception) {

                        }
                        Company(it.companyName, it.symbol, it.primaryExchange, logo.url, sector)
                    }
                } else {
                    listOf()
                }
                companies.addAll(companiesWithLogo)
            }
        companyRepository.saveAll(companies)
    }
}