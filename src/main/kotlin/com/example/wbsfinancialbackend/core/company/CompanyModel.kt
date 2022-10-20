package com.example.wbsfinancialbackend.core.company

import com.example.wbsfinancialbackend.core.company.categories.SectorModel
import java.io.Serializable

data class CompanyModel(
    var id: Int,
    val companyName: String,
    val symbol: String,
    val exchange: String?,
    var logo: String,
    val description: String,
    val country: String,
    val ceo: String,
    val website: String,
    val employees: Int,
    val industry: String?,
    val sectorModel: SectorModel?
): Serializable