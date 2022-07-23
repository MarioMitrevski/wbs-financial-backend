package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.util.*

data class QuarterlyEarningDTO(
    @JsonProperty("fiscalDateEnding") val fiscalDateEnding: Date,
    @JsonProperty("reportedDate") val reportedDate: Date,
    @JsonProperty("reportedEPS") val reportedEPS: String,
    @JsonProperty("estimatedEPS") val estimatedEPS: String,
    @JsonProperty("surprise") val surprise: String,
    @JsonProperty("surprisePercentage") val surprisePercentage: String
): Serializable