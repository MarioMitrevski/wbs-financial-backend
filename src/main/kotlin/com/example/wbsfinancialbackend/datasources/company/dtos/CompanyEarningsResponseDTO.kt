package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class CompanyEarningsResponseDTO(
    @JsonProperty("annualEarnings") var annualEarnings: List<AnnualEarningDTO>?,
    @JsonProperty("quarterlyEarnings") var quarterlyEarnings: List<QuarterlyEarningDTO>?
): Serializable