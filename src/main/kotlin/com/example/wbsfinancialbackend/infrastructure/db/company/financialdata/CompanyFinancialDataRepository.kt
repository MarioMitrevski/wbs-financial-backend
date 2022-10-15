package com.example.wbsfinancialbackend.infrastructure.db.company.financialdata

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyFinancialDataRepository: JpaRepository<CompanyFinancialData, Int> {

    fun findAllByCompanyId(id: Int): List<CompanyFinancialData>
}