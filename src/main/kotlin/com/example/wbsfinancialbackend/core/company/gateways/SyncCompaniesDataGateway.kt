package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.core.company.CompanyModel
import com.example.wbsfinancialbackend.core.company.categories.SectorModel
import com.example.wbsfinancialbackend.infrastructure.datasources.company.dtos.CompanyDTO

interface SyncCompaniesDataGateway {
    fun getCompaniesBySector(sector: String): List<CompanyDTO>
    fun getCompanyDetails(symbol: String): CompanyModel
    fun findAllByActive(): List<SectorModel>
    fun saveCompanies(companies: Set<CompanyModel>)
}