package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class CompanyAnnualReportsDTO(
    @JsonProperty("annualReports") val annualReports: List<CompanyAnnualReportDTO>
): Serializable