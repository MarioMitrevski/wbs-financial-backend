package com.example.wbsfinancialbackend.datasources.company.dtos

import com.example.wbsfinancialbackend.api.PaginationResponseDTO
import com.example.wbsfinancialbackend.db.company.Company

data class CompaniesBasicInfoDTO(
    val pagination: PaginationResponseDTO,
    val data: List<CompanyBasicInfoDTO>
)

data class CompanyBasicInfoDTO(
    val companyName: String,
    val symbol: String,
    val exchange: String,
    val logoUrl: String,
)

fun Company.mapToCompanyBasicInfoDTO(): CompanyBasicInfoDTO {
    return CompanyBasicInfoDTO(
        this.companyName,
        this.symbol,
        this.exchange ?: "",
        this.logo
    )
}