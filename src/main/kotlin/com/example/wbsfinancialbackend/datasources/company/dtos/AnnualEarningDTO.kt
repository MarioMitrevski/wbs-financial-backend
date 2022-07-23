package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.util.*

data class AnnualEarningDTO(
    @JsonProperty("fiscalDateEnding") val fiscalDateEnding: Date,
    @JsonProperty("reportedEPS") val reportedEPS: String
): Serializable