package com.example.wbsfinancialbackend.core.company.usecases

import com.example.wbsfinancialbackend.core.company.CompanyModel
import com.example.wbsfinancialbackend.core.company.gateways.SyncCompaniesDataGateway
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyDTO
import com.example.wbsfinancialbackend.infrastructure.exceptions.NotFoundException
import kotlinx.coroutines.*
import org.springframework.transaction.annotation.Transactional
import kotlin.system.measureNanoTime

@UseCase
class SyncCompaniesData(
    val syncCompaniesDataGateway: SyncCompaniesDataGateway,
    val getCompanyDetails: GetCompanyDetails,
    val getCompanyLogo: GetCompanyLogo
) {

    @Transactional
    operator fun invoke() {
        val companies: MutableSet<CompanyModel> = mutableSetOf()
        runBlocking {
            launch {
                withContext(Dispatchers.IO) {
                    syncCompaniesDataGateway.findAllByActive()
                }
                    .forEach { sector ->
                        val companiesDTOInSector: List<CompanyDTO>
                        var elapsed = measureNanoTime {
                            companiesDTOInSector = syncCompaniesDataGateway.getCompaniesBySector(sector.name)
                        }
                        delayUntilNextCall(elapsed)
                        if (companiesDTOInSector.isNotEmpty()) {
                            companiesDTOInSector.subList(0, 1).map {

                                try {
                                    val logo: String
                                    var company: CompanyModel
                                    elapsed = measureNanoTime {
                                        logo = getCompanyLogo(it.symbol).url
                                    }
                                    delayUntilNextCall(elapsed)
                                    elapsed = measureNanoTime {
                                        company = syncCompaniesDataGateway.getCompanyDetails(it.symbol)
                                    }
                                    delayUntilNextCall(elapsed)
                                    company = company.copy(logo = logo, sectorModel = sector)
                                    withContext(Dispatchers.IO) {
                                        try {
                                            getCompanyDetails.invoke(it.symbol).run {
                                                company.id = this.id
                                            }
                                        } catch (_: NotFoundException){}
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
        syncCompaniesDataGateway.saveCompanies(companies)
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