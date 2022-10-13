package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.datasources.IEXClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyDTO
import com.example.wbsfinancialbackend.datasources.company.dtos.CompanyDetailsResponseDTO
import com.example.wbsfinancialbackend.datasources.company.dtos.mapToCompany
import com.example.wbsfinancialbackend.db.company.Company
import com.example.wbsfinancialbackend.db.company.CompanyRepository
import com.example.wbsfinancialbackend.db.company.sector.SectorRepository
import kotlinx.coroutines.*
import org.springframework.transaction.annotation.Transactional
import kotlin.system.measureNanoTime

@UseCase
class SyncCompaniesData(
    val iexClient: IEXClient,
    val sectorRepository: SectorRepository,
    val companyRepository: CompanyRepository,
    val getCompanyLogo: GetCompanyLogo
) {

    @Transactional
    operator fun invoke() {
        val companies: MutableSet<Company> = mutableSetOf()
        runBlocking {
            launch {
                withContext(Dispatchers.IO) {
                    sectorRepository.findAllByActive()
                }
                    .forEach { sector ->
                        val companiesDTOInSector: List<CompanyDTO>
                        var elapsed = measureNanoTime {
                            companiesDTOInSector = iexClient.getCompaniesBySector(sector.name)
                        }
                        delayUntilNextCall(elapsed)
                        if (companiesDTOInSector.isNotEmpty()) {
                            companiesDTOInSector.subList(0, 1).map {

                                try {
                                    val logo: String
                                    val company: Company
                                    var companyDetailsResponseDTO: CompanyDetailsResponseDTO
                                    elapsed = measureNanoTime {
                                        logo = getCompanyLogo(it.symbol).url
                                    }
                                    delayUntilNextCall(elapsed)
                                    elapsed = measureNanoTime {
                                        companyDetailsResponseDTO = iexClient.getCompanyDetails(it.symbol)
                                    }
                                    delayUntilNextCall(elapsed)
                                    companyDetailsResponseDTO = companyDetailsResponseDTO.copy(logo = logo)
                                    company = companyDetailsResponseDTO.mapToCompany(sector);
                                    withContext(Dispatchers.IO) {
                                        companyRepository.findCompanyBySymbol(it.symbol)
                                    }.ifPresent { existingCompany ->
                                        company.id = existingCompany.id
                                    }
                                    companies.add(company)
                                } catch (_: Exception) {
                                    throw Exception("Sync companies data failed!")
                                }
                            }
                        }
                    }
            }
        }
        companyRepository.saveAll(companies)
    }

    private suspend fun delayUntilNextCall(elapsed: Long) {
        val remainingMillisecondsTillNextCall =
            getRemainingMillisecondsTillNextCall(elapsed)
        if (remainingMillisecondsTillNextCall > 0) {
            delay(remainingMillisecondsTillNextCall)
        }
    }

    fun getRemainingMillisecondsTillNextCall(elapsed: Long): Long {
        val elapsedInMilliseconds = elapsed / 1000000
        return IEX_CLIENT_TOO_MANY_REQUESTS_TIME_IN_MILLISECONDS - elapsedInMilliseconds

    }

    companion object {
        private const val IEX_CLIENT_TOO_MANY_REQUESTS_TIME_IN_MILLISECONDS = 100

    }
}