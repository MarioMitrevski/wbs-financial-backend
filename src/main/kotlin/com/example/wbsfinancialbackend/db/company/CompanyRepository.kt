package com.example.wbsfinancialbackend.db.company

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CompanyRepository: JpaRepository<Company, UUID> {

    @Query("SELECT c.logoUrl, c.symbol FROM Company c WHERE c.symbol in :symbols")
    fun findAllLogosBySymbol(symbols: List<String>): List<CompanyLogoProjection>
}