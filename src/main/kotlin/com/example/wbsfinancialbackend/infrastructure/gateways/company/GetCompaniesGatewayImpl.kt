package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.gateways.GetCompaniesGateway
import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.companies.dtos.CompaniesRequest
import com.example.wbsfinancialbackend.infrastructure.db.company.Company
import com.example.wbsfinancialbackend.infrastructure.db.company.CompanyRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class GetCompaniesGatewayImpl(
    val companyRepository: CompanyRepository
): GetCompaniesGateway {
    override fun findAllBySectorNameAndQuery(pageRequestDTO: PageRequestDTO<CompaniesRequest>): Page<Company> {
        return companyRepository
            .findAllBySectorNameAndQuery(
                pageRequestDTO.filterBy.sector,
                pageRequestDTO.filterBy.query,
                Pageable.ofSize(pageRequestDTO.size)
                    .withPage(pageRequestDTO.page)
            )
    }
}