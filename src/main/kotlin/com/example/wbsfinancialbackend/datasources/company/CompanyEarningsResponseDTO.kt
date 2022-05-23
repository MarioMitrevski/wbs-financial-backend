package com.example.wbsfinancialbackend.datasources.company

import com.fasterxml.jackson.annotation.JsonProperty

data class CompanyEarningsResponseDTO(
    @get:JsonProperty("annualEarnings") var annualEarnings: List<AnnualEarningDTO>,
    @get:JsonProperty("quarterlyEarnings") var quarterlyEarnings: List<QuarterlyEarningDTO>
)