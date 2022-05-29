package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class AnnualEarningDTO(
    @get:JsonProperty("fiscalDateEnding") val fiscalDateEnding: Date,
    @get:JsonProperty("reportedEPS") val reportedEPS: String
)