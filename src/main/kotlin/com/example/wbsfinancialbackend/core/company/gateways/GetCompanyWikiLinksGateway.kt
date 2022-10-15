package com.example.wbsfinancialbackend.core.company.gateways

interface GetCompanyWikiLinksGateway {
    fun getCompanyWikiLinks(
        companyName: String,
        predicate: String
    ): List<String>
}