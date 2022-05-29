package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class CompanyAnnualReportDTO(
    @get:JsonProperty("costOfRevenue") val costOfRevenue: String,
    @get:JsonProperty("grossProfit") val grossProfit: String,
    @get:JsonProperty("netIncome") val netIncome: String,
    @get:JsonProperty("totalRevenue") val totalRevenue: String,
    @get:JsonProperty("operatingIncome") val operatingIncome: String,
    @get:JsonProperty("incomeBeforeTax") val incomeBeforeTax: String,
    @get:JsonProperty("incomeTaxExpense") val incomeTaxExpense: String
)