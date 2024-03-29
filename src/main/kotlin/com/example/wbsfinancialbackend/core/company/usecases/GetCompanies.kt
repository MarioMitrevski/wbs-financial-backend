package com.example.wbsfinancialbackend.core.company.usecases

import com.example.wbsfinancialbackend.core.company.CompanyModel
import com.example.wbsfinancialbackend.core.company.gateways.GetCompaniesGateway
import com.example.wbsfinancialbackend.infrastructure.api.PageRequestDTO
import com.example.wbsfinancialbackend.infrastructure.api.companies.dtos.CompaniesRequest
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import org.springframework.data.domain.Page

@UseCase
class GetCompanies(
    val getCompaniesGateway: GetCompaniesGateway
) {
    operator fun invoke(pageRequestDTO: PageRequestDTO<CompaniesRequest>): Page<CompanyModel> {
        return getCompaniesGateway.findAllBySectorNameAndQuery(pageRequestDTO)
    }
}