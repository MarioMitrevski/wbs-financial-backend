package com.example.wbsfinancialbackend.db

import com.example.wbsfinancialbackend.db.company.sector.Sector
import com.example.wbsfinancialbackend.db.company.sector.SectorRepository
import com.example.wbsfinancialbackend.domain.company.usecases.SyncCompaniesData
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DbInit(
    val syncCompaniesData: SyncCompaniesData,
    val sectorRepository: SectorRepository
) {

    @PostConstruct
    private fun postConstruct() {
        /*sectorRepository.saveAll(
            listOf(
                Sector("Energy Minerals", true),
                Sector("Electronic Technology", true),
                Sector("Real Estate and Rental and Leasing", true),
                Sector("Non-Energy Minerals", true),
                Sector("Other Services (except Public Administration)", false),
                Sector("Retail Trade", false),
                Sector("Communications", true),
                Sector("Arts, Entertainment, and Recreation", false),
                Sector("Transportation and Warehousing", false),
                Sector("Consumer Services", false),
                Sector("Health Services", true),
                Sector("Information", false),
                Sector("Agriculture, Forestry, Fishing and Huntin", false),
                Sector("Educational Services", false),
                Sector("Public Administration", false),
                Sector("Health Care and Social Assistance", false),
                Sector("Utilities", false),
                Sector("Consumer Non-Durables", false),
                Sector("Commercial Services", false),
                Sector("Process Industries", false),
                Sector("Finance and Insurance", true),
                Sector("Industrial Services", false),
                Sector("Administrative and Support and Waste Management and Remediation Services", false),
                Sector("Manufacturing", false),
                Sector("Transportation", true),
                Sector("Mining, Quarrying, and Oil and Gas Extraction", false),
                Sector("Technology Services", false),
                Sector("Miscellaneous", false),
                Sector("Finance", false),
                Sector("Consumer Durables", false),
                Sector("Producer Manufacturing", false),
                Sector("Construction", true),
                Sector("Accommodation and Food Services", false),
                Sector("Health Technology", true),
                Sector("Professional, Scientific, and Technical Services", false),
                Sector("Management of Companies and Enterprises", false),
                Sector("Government", false)
            )
        )*/
        //syncCompaniesData.invoke()

    }
}