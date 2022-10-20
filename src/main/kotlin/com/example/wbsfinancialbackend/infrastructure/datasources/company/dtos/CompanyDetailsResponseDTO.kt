package com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos

import com.example.wbsfinancialbackend.core.company.CompanyModel
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class CompanyDetailsResponseDTO(
    @JsonProperty("id") val id: Int,
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
): Serializable

fun CompanyDetailsResponseDTO.mapToCompanyModel(): CompanyModel {
    return CompanyModel(
        this.id,
        this.companyName,
        this.symbol,
        this.exchange,
        this.logo?: "",
        this.description,
        this.country?: "",
        this.ceo?: "",
        this.website?: "",
        this.employees?: 0,
        this.industry,
        null
    )
}