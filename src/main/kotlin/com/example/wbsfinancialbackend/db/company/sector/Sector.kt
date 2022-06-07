package com.example.wbsfinancialbackend.db.company.sector

import com.example.wbsfinancialbackend.db.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "sectors")
data class Sector(
    val name: String,
    val active: Boolean
): BaseEntity()