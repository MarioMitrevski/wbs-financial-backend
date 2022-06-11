package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.api.PageRequestDTO
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.db.company.Company
import com.example.wbsfinancialbackend.db.company.CompanyRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@UseCase
class GetCompanies(
    val companyRepository: CompanyRepository
) {
    operator fun invoke(pageRequestDTO: PageRequestDTO, sector: String?, query: String?): Page<Company> {
        return companyRepository
            .findAllBySectorNameAndQuery(
                sector,
                query,
                Pageable.ofSize(pageRequestDTO.size)
                    .withPage(pageRequestDTO.page)
            )
    }
}