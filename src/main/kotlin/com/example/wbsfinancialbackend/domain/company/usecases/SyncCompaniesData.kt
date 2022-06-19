package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.IEXClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.db.company.Company
import com.example.wbsfinancialbackend.db.company.CompanyRepository
import com.example.wbsfinancialbackend.db.company.sector.SectorRepository

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
                if (companiesDTOInSector.isNotEmpty()) {
                    companiesDTOInSector.subList(0, 1).map {

                        try {
                            val logo = iexClient.getCompanyLogo(it.symbol)
                            val companyDetails = iexClient.getCompanyDetails(it.symbol)
                            val newCompany = Company(
                                companyDetails.companyName,
                                companyDetails.symbol,
                                companyDetails.exchange,
                                logo.url,
                                companyDetails.description,
                                companyDetails.country?: "",
                                companyDetails.ceo?: "",
                                companyDetails.website?: "",
                                companyDetails.employees?: 0,
                                sector
                            )
                            companyRepository.findCompanyBySymbol(it.symbol).ifPresent { company ->
                                newCompany.id = company.id
                            }

                            companyRepository.save(newCompany)
                        } catch (_: Exception) {

                        }
                    }
                }
            }
        companyRepository.saveAll(companies)
    }
}