package com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos

import com.example.wbsfinancialbackend.core.company.CompanyModel
import com.example.wbsfinancialbackend.infrastructure.api.PaginationResponseDTO

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

fun CompanyModel.mapToCompanyBasicInfoDTO(): CompanyBasicInfoDTO {
    return CompanyBasicInfoDTO(
        this.companyName,
        this.symbol,
        this.exchange ?: "",
        this.logo
    )
}