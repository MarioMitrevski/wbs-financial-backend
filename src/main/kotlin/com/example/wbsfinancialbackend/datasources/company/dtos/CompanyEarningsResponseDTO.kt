package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class CompanyEarningsResponseDTO(
    @get:JsonProperty("annualEarnings") var annualEarnings: List<AnnualEarningDTO>,
    @get:JsonProperty("quarterlyEarnings") var quarterlyEarnings: List<QuarterlyEarningDTO>
)