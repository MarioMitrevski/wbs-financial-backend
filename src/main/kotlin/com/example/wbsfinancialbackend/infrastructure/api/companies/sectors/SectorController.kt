package com.example.wbsfinancialbackend.infrastructure.api.companies.sectors

import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.core.company.categories.usecases.GetCompanySectors
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