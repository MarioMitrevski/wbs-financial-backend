package com.example.wbsfinancialbackend.api.company

interface CompanyService {

    fun getCompanyWikiLinks(companyName: String, predicate: String): List<String>
}