package com.example.wbsfinancialbackend.infrastructure.api.companies.dtos

data class CompaniesRequest(
    val sector: String?,
    val query: String?
)