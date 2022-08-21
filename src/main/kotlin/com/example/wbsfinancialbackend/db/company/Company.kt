package com.example.wbsfinancialbackend.db.company

import com.example.wbsfinancialbackend.db.BaseEntity
import com.example.wbsfinancialbackend.db.company.sector.Sector
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", referencedColumnName = "id")
    var sector: Sector
) : BaseEntity()