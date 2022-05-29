package com.example.wbsfinancialbackend.db

import com.example.wbsfinancialbackend.db.sector.Sector
import com.example.wbsfinancialbackend.db.sector.SectorRepository
import com.example.wbsfinancialbackend.domain.company.usecases.SyncCompaniesData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DbInit(
    val syncCompaniesData: SyncCompaniesData,
    val sectorRepository: SectorRepository
) {

    @PostConstruct
    private fun postConstruct() {
        sectorRepository.saveAll(
            listOf(
                Sector("Energy Minerals"),
                Sector("Electronic Technology"),
                Sector("Real Estate and Rental and Leasing"),
                Sector("Non-Energy Minerals"),
                Sector("Other Services (except Public Administration)"),
                Sector("Retail Trade"),
                Sector("Communications"),
                Sector("Arts, Entertainment, and Recreation"),
                Sector("Transportation and Warehousing"),
                Sector("Consumer Services"),
                Sector("Health Services"),
                Sector("Information"),
                Sector("Agriculture, Forestry, Fishing and Huntin"),
                Sector("Educational Services"),
                Sector("Public Administration"),
                Sector("Health Care and Social Assistance"),
                Sector("Utilities"),
                Sector("Consumer Non-Durables"),
                Sector("Commercial Services"),
                Sector("Process Industries"),
                Sector("Finance and Insurance"),
                Sector("Industrial Services"),
                Sector("Administrative and Support and Waste Management and Remediation Services"),
                Sector("Manufacturing"),
                Sector("Transportation"),
                Sector("Mining, Quarrying, and Oil and Gas Extraction"),
                Sector("Technology Services"),
                Sector("Miscellaneous"),
                Sector("Finance"),
                Sector("Consumer Durables"),
                Sector("Producer Manufacturing"),
                Sector("Construction"),
                Sector("Accommodation and Food Services"),
                Sector("Health Technology"),
                Sector("Professional, Scientific, and Technical Services"),
                Sector("Management of Companies and Enterprises"),
                Sector("Government")
            )
        )
        syncCompaniesData.invoke()

    }
}