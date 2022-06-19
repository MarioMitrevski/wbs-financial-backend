package com.example.wbsfinancialbackend.db.company

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CompanyRepository : JpaRepository<Company, Int> {

    @Query("SELECT c.logo, c.symbol FROM Company c WHERE c.symbol in :symbols")
    fun findAllLogosBySymbol(symbols: List<String>): List<CompanyLogoProjection>

    @Query("SELECT c FROM Company c WHERE (:query is null or (c.symbol LIKE CONCAT('%',:query,'%') or c.companyName LIKE CONCAT('%',:query,'%'))) and (:sector is null or c.sector.name = :sector)")
    fun findAllBySectorNameAndQuery(sector: String?, query: String?, pageable: Pageable): Page<Company>

    fun findCompanyBySymbol(symbol: String): Optional<Company>
}