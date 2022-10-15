package com.example.wbsfinancialbackend.infrastructure.db.company.financialdata

import com.example.wbsfinancialbackend.core.company.CompanyFinancialDataModel
import com.example.wbsfinancialbackend.infrastructure.db.BaseEntity
import com.example.wbsfinancialbackend.infrastructure.db.company.Company
import com.example.wbsfinancialbackend.infrastructure.db.company.mapToCompanyModel
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "companies_financial_data")
class CompanyFinancialData(
    val totalRevenue: BigDecimal?,
    val costOfRevenue: BigDecimal?,
    val grossProfit: BigDecimal?,
    val fiscalYear: String,
    val netIncome: BigDecimal?,
    val incomeTax: BigDecimal?,
    val operatingIncome: BigDecimal?,
    val pretaxIncome: BigDecimal?,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    var company: Company
) : BaseEntity()

fun CompanyFinancialData.mapToCompanyFinancialDataModel(): CompanyFinancialDataModel {
    return CompanyFinancialDataModel(
        this.id,
        this.totalRevenue,
        this.costOfRevenue,
        this.grossProfit,
        this.fiscalYear,
        this.netIncome,
        this.incomeTax,
        this.operatingIncome,
        this.pretaxIncome,
        this.company.mapToCompanyModel()
    )
}