package com.example.wbsfinancialbackend.datasources.company

import com.example.wbsfinancialbackend.domain.company.usecases.SyncCompaniesData
import lombok.RequiredArgsConstructor
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component


@Component
@RequiredArgsConstructor
class CompaniesSyncJob(
    val syncCompaniesData: SyncCompaniesData
) {

    @Scheduled(cron = "\${cron.companies.expression}", zone = "Europe/Skopje")
    fun syncData() {
        syncCompaniesData.invoke()
    }
}