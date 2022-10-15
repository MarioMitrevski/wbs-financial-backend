package com.example.wbsfinancialbackend.core.company.gateways

import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.companies.dtos.CompaniesRequest
import com.example.wbsfinancialbackend.infrastructure.db.company.Company
import org.springframework.data.domain.Page

interface GetCompaniesGateway {
    fun findAllBySectorNameAndQuery(pageRequestDTO: PageRequestDTO<CompaniesRequest>): Page<Company>
}