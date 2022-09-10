package com.example.wbsfinancialbackend.api.companies.dtos

data class CompaniesRequest(
    val sector: String?,
    val query: String?
)