package com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos

import java.time.LocalDate

data class CompanyPriceDTO(
    val close: Double,
    val high: Double,
    val low: Double,
    val open: Double,
    val date: LocalDate
)