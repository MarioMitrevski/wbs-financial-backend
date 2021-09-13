package com.example.wbsfinancialbackend.api.company

import java.util.concurrent.CompletableFuture


interface CompanyService {

    fun getCompanyWikiLinks(companyName: String, predicate: String, isSubject: Boolean): CompletableFuture<List<String>>
}