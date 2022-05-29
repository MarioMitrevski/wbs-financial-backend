package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class QuarterlyEarningDTO(
    @get:JsonProperty("fiscalDateEnding") val fiscalDateEnding: Date,
    @get:JsonProperty("reportedDate") val reportedDate: Date,
    @get:JsonProperty("reportedEPS") val reportedEPS: String,
    @get:JsonProperty("estimatedEPS") val estimatedEPS: String,
    @get:JsonProperty("surprise") val surprise: String,
    @get:JsonProperty("surprisePercentage") val surprisePercentage: String
)