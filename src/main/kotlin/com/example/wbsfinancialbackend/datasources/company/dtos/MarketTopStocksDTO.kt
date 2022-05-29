package com.example.wbsfinancialbackend.datasources.company.dtos

data class MarketTopStocksDTO(
    val companyName: String,
    val primaryExchange: String,
    val symbol: String,
    val changePercent: Float,
    val logo: String?
)