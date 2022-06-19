package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class CompanyDetailsResponseDTO(
    @JsonProperty("companyName") val companyName: String,
    @JsonProperty("symbol") val symbol: String,
    @JsonProperty("logo") val logo: String?,
    @JsonProperty("industry") val industry: String,
    @JsonProperty("website") val website: String?,
    @JsonProperty("country") val country: String?,
    @JsonProperty("exchange") val exchange: String?,
    @JsonProperty("CEO") val ceo: String?,
    @JsonProperty("description") val description: String,
    @JsonProperty("employees") val employees: Int?
)