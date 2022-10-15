package com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos

data class CompanyDTO(
    val companyName: String,
    val symbol: String,
    val primaryExchange: String?
)