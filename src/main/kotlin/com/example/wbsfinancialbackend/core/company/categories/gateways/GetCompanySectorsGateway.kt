package com.example.wbsfinancialbackend.core.company.categories.gateways

import com.example.wbsfinancialbackend.core.company.categories.SectorModel

interface GetCompanySectorsGateway {
    fun findAllByActive(): List<SectorModel>
}