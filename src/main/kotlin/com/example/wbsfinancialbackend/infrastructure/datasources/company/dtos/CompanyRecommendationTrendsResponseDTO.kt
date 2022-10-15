package com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class CompanyRecommendationTrendsResponseDTO(
    @JsonProperty("buy") val buy: Int,
    @JsonProperty("strongBuy") val strongBuy: Int,
    @JsonProperty("hold") val hold: Int,
    @JsonProperty("sell") val sell: Int,
    @JsonProperty("strongSell") val strongSell: Int,
    @JsonProperty("period") val period: Date
)