package com.example.wbsfinancialbackend.datasources.company

import com.fasterxml.jackson.annotation.JsonProperty

data class CompanyDetailsResponseDTO(
    @get:JsonProperty("name") val name: String,
    @get:JsonProperty("logo") val logo: String,
    @get:JsonProperty("finnhubIndustry") val finnhubIndustry: String,
    @get:JsonProperty("weburl") val weburl: String,
    @get:JsonProperty("country") val country: String,
    @get:JsonProperty("shareOutstanding") val shareOutstanding: String,
    @get:JsonProperty("exchange") val exchange: String,
    @get:JsonProperty("ipo") val ipo: String,
    @get:JsonProperty("marketCapitalization") val marketCapitalization: String,
)