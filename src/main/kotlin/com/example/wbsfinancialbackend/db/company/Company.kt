package com.example.wbsfinancialbackend.db.company

import com.example.wbsfinancialbackend.db.sector.Sector
import lombok.experimental.SuperBuilder
import javax.persistence.*

@Entity
@Table(name = "companies")
class Company(
    val companyName: String,

    val symbol: String,

    val exchange: String?,

    val logoUrl: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id", referencedColumnName = "id")
    val sector: Sector
) : BaseEntity()