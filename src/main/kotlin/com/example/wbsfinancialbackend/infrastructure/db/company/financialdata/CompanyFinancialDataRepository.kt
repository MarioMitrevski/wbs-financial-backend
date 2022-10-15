package com.example.wbsfinancialbackend.infrastructure.db.company.financialdata

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CompanyFinancialDataRepository: JpaRepository<CompanyFinancialData, Int> {

    fun findByCompanyIdAndFiscalYear(id: Int, fiscalYear: String): Optional<CompanyFinancialData>
}