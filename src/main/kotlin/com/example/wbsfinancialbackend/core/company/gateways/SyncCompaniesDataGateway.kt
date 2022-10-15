package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyDTO
import com.example.wbsfinancialbackend.infrastructure.db.company.Company
import com.example.wbsfinancialbackend.infrastructure.db.company.sector.Sector

interface SyncCompaniesDataGateway {
    fun getCompaniesBySector(sector: String): List<CompanyDTO>
    fun findCompanyBySymbol(symbol: String): Company?
    fun findAllByActive(): List<Sector>
    fun saveCompanies(companies: Set<Company>)
}