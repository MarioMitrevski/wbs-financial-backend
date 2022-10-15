package com.example.wbsfinancialbackend.core.company

import java.io.Serializable
import java.math.BigDecimal

data class CompanyFinancialDataModel(
    val id: Int,
    val totalRevenue: BigDecimal?,
    val costOfRevenue: BigDecimal?,
    val grossProfit: BigDecimal?,
    val fiscalYear: String,
    val netIncome: BigDecimal?,
    val incomeTax: BigDecimal?,
    val operatingIncome: BigDecimal?,
    val pretaxIncome: BigDecimal?,
    var company: CompanyModel
) : Serializable