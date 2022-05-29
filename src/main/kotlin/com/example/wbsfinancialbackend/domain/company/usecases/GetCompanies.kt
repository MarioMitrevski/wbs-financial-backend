package com.example.wbsfinancialbackend.domain.company.usecases

import com.example.wbsfinancialbackend.api.PageRequestDTO
import com.example.wbsfinancialbackend.api.PaginationResponseDTO
import com.example.wbsfinancialbackend.constants.endpoints.DEFAULT_PAGE
import com.example.wbsfinancialbackend.constants.endpoints.DEFAULT_PAGE_SIZE
import com.example.wbsfinancialbackend.datasources.IEXClient
import com.example.wbsfinancialbackend.datasources.MarketStackClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.company.dtos.CompaniesBasicInfoDTO

@UseCase
class GetCompanies(
    val iexClient: IEXClient
) {
    operator fun invoke(pageRequestDTO: PageRequestDTO, query: String): CompaniesBasicInfoDTO {
        return CompaniesBasicInfoDTO(PaginationResponseDTO(0), listOf())
    }
}