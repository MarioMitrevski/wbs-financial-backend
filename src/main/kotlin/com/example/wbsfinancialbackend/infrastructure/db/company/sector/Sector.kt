package com.example.wbsfinancialbackend.infrastructure.db.company.sector

import com.example.wbsfinancialbackend.core.company.categories.SectorModel
import com.example.wbsfinancialbackend.infrastructure.db.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "sectors")
data class Sector(
    val name: String,
    val active: Boolean
): BaseEntity()

fun Sector.mapToSectorModel(): SectorModel {
    return SectorModel(
        this.id,
        this.name,
        this.active
    )
}

fun SectorModel.mapToSector(): Sector {
    val id = this.id
    return Sector(
        this.name,
        this.active
    ).apply {
        this.id = id
    }
}