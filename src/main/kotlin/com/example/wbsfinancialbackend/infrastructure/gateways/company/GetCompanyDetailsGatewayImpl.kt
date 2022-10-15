package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.CompanyModel
import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyDetailsGateway
import com.example.wbsfinancialbackend.infrastructure.constants.ErrorMessages
import com.example.wbsfinancialbackend.infrastructure.db.company.Company
import com.example.wbsfinancialbackend.infrastructure.db.company.CompanyRepository
import com.example.wbsfinancialbackend.infrastructure.db.company.mapToCompanyModel
import com.example.wbsfinancialbackend.infrastructure.exceptions.NotFoundException
import org.springframework.stereotype.Service

@Service
class GetCompanyDetailsGatewayImpl(
    val companyRepository: CompanyRepository
) : GetCompanyDetailsGateway {
    override fun findCompanyBySymbol(symbol: String): CompanyModel {
        return companyRepository.findCompanyBySymbol(symbol).orElseThrow {
            throw NotFoundException(ErrorMessages.entityNotFoundMessage(Company::class.java.simpleName, symbol))
        }.mapToCompanyModel()
    }
}