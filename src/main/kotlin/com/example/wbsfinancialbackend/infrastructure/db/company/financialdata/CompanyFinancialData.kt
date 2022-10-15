package com.example.wbsfinancialbackend.infrastructure.db.company.financialdata

import com.example.wbsfinancialbackend.infrastructure.db.BaseEntity
import com.example.wbsfinancialbackend.infrastructure.db.company.Company
import java.math.BigDecimal
import java.time.Year
import javax.persistence.*


@Entity
@Table(name = "companies_financial_data")
class CompanyFinancialData(
    val totalRevenue: BigDecimal,
    val costOfRevenue: BigDecimal,
    val grossProfit: BigDecimal,
    val fiscalYear: Year,
    val netIncome: BigDecimal,
    val incomeTax: BigDecimal,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    var company: Company
) : BaseEntity()