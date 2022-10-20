package com.example.wbsfinancialbackend.infrastructure.db.company

import com.example.wbsfinancialbackend.core.company.CompanyModel
import com.example.wbsfinancialbackend.infrastructure.db.BaseEntity
import com.example.wbsfinancialbackend.infrastructure.db.company.sector.Sector
import com.example.wbsfinancialbackend.infrastructure.db.company.sector.mapToSector
import com.example.wbsfinancialbackend.infrastructure.db.company.sector.mapToSectorModel
import javax.persistence.*

@Entity
@Table(name = "companies")
class Company(
    val companyName: String,
    val symbol: String,
    val exchange: String?,
    var logo: String,
    @Column(length = 10000) val description: String,
    val country: String,
    val ceo: String,
    val website: String,
    val employees: Int,
    val industry: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", referencedColumnName = "id")
    var sector: Sector?
) : BaseEntity()


fun Company.mapToCompanyModel(): CompanyModel {
    return CompanyModel(
        this.id,
        this.companyName,
        this.symbol,
        this.exchange,
        this.logo,
        this.description,
        this.country,
        this.ceo,
        this.website,
        this.employees,
        this.industry,
        this.sector?.mapToSectorModel()
    )
}

fun CompanyModel.mapToCompany(): Company {
    val id = this.id
    return Company(
        this.companyName,
        this.symbol,
        this.exchange,
        this.logo,
        this.description,
        this.country,
        this.ceo,
        this.website,
        this.employees,
        this.industry?: "",
        this.sectorModel?.mapToSector()
    ).apply { this.id = id }
}