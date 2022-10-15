package com.example.wbsfinancialbackend.core.company.categories.gateways

import com.example.wbsfinancialbackend.infrastructure.db.company.sector.Sector

interface GetCompanySectorsGateway {
    fun findAllByActive(): List<Sector>
}