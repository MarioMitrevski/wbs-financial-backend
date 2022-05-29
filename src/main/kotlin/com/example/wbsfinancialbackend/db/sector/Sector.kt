package com.example.wbsfinancialbackend.db.sector

import com.example.wbsfinancialbackend.db.company.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "sectors")
class Sector(
    val name: String
): BaseEntity()