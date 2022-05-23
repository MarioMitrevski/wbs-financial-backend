package com.example.wbsfinancialbackend.domain.company.usecases

import com.fasterxml.jackson.annotation.JsonProperty

data class CompanyResponseDTO(
    @get:JsonProperty("description") val description: String,
    @get:JsonProperty("symbol") val symbol: String,
)

data class SearchCompanyResponseDTO(
    @get:JsonProperty("result") val result: List<CompanyResponseDTO>
)