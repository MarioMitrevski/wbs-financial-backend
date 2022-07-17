package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class CompanyAnnualReportsDTO(
    @JsonProperty("annualReports") val annualReports: List<CompanyAnnualReportDTO>
)