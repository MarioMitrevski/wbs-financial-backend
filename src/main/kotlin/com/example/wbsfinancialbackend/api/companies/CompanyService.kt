package com.example.wbsfinancialbackend.api.companies

interface CompanyService {

    fun getCompanyWikiLinks(companyName: String, predicate: String): List<String>
}