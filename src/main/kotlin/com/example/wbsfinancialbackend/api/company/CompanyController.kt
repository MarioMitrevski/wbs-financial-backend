package com.example.wbsfinancialbackend.api.company

import com.example.wbsfinancialbackend.constants.WBSFinancialEndpoints
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.COMPANY_ENDPOINT])
class CompanyController(val companyService: CompanyService) {

    @GetMapping(path = ["/{name}/wikiLinks"])
    fun getCompanyWikiLinks(
        @PathVariable name: String,
        @RequestParam(name = "predicate") predicate: String,
        @RequestParam(name = "isSubject") isSubject: Boolean
    ): CompletableFuture<List<String>> {
        return companyService.getCompanyWikiLinks(name, predicate, isSubject)
    }
}