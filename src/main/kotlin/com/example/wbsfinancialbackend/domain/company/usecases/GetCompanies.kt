package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.api.PageRequestDTO
import com.example.wbsfinancialbackend.constants.endpoints.DEFAULT_PAGE
import com.example.wbsfinancialbackend.constants.endpoints.DEFAULT_PAGE_SIZE
import com.example.wbsfinancialbackend.datasources.MarketStackClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.CompaniesBasicInfoDTO

@UseCase
class GetCompanies(
    val marketStackClient: MarketStackClient
) {
    operator fun invoke(pageRequestDTO: PageRequestDTO, query: String): CompaniesBasicInfoDTO {
        return marketStackClient.getCompanies(
            pageRequestDTO.page ?: DEFAULT_PAGE,
            pageRequestDTO.size ?: DEFAULT_PAGE_SIZE,
            query
        )
    }
}