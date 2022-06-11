package com.example.wbsfinancialbackend.api.companies.dtos

import com.example.wbsfinancialbackend.api.PageRequestDTO

data class CompaniesRequestDTO(
    val pageRequest: PageRequestDTO?,
    val sector: String?,
    val query: String?
)