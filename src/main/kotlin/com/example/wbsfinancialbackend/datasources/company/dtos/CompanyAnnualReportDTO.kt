package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class CompanyAnnualReportDTO(
    @JsonProperty("costOfRevenue") val costOfRevenue: String,
    @JsonProperty("grossProfit") val grossProfit: String,
    @JsonProperty("netIncome") val netIncome: String,
    @JsonProperty("totalRevenue") val totalRevenue: String,
    @JsonProperty("operatingIncome") val operatingIncome: String,
    @JsonProperty("incomeBeforeTax") val incomeBeforeTax: String,
    @JsonProperty("incomeTaxExpense") val incomeTaxExpense: String
)