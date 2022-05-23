package com.example.wbsfinancialbackend.datasources.company

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class CompanyRecommendationTrendsResponseDTO(
    @get:JsonProperty("buy") val buy: Int,
    @get:JsonProperty("strongBuy") val strongBuy: Int,
    @get:JsonProperty("hold") val hold: Int,
    @get:JsonProperty("sell") val sell: Int,
    @get:JsonProperty("strongSell") val strongSell: Int,
    @get:JsonProperty("period") val period: Date,
)