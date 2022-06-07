package com.example.wbsfinancialbackend.api.companies.sectors

import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.domain.company.categories.usecases.GetCompanySectors
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.COMPANY_SECTOR_ENDPOINT])
class SectorController(
    val getCompanySectors: GetCompanySectors
) {

    @GetMapping
    fun getCompanySectors(): ResponseEntity<List<String>> {
        return ResponseEntity.ok(getCompanySectors.invoke())
    }
}