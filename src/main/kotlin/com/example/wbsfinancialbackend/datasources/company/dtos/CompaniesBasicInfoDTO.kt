package com.example.wbsfinancialbackend.datasources.company.dtos

import com.example.wbsfinancialbackend.api.PaginationResponseDTO

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