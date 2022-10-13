package com.example.wbsfinancialbackend.datasources.company.dtos

import com.example.wbsfinancialbackend.db.company.Company
import com.example.wbsfinancialbackend.db.company.sector.Sector
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

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
): Serializable

fun CompanyDetailsResponseDTO.mapToCompany(sector: Sector): Company {
    return Company(
        this.companyName,
        this.symbol,
        this.exchange,
        this.logo?: "",
        this.description,
        this.country?: "",
        this.ceo?: "",
        this.website?: "",
        this.employees?: 0,
        sector
    )
}

fun Company.mapToCompanyDetailsResponseDTO(): CompanyDetailsResponseDTO {
    return CompanyDetailsResponseDTO(
        this.companyName,
        this.symbol,
        this.logo,
        this.sector.name,
        this.website,
        this.country,
        this.exchange ?: "",
        this.ceo,
        this.description,
        this.employees
    )
}