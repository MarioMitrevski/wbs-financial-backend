package com.example.wbsfinancialbackend.core.company.categories

import java.io.Serializable

data class SectorModel(
    val id: Int,
    val name: String,
    val active: Boolean
): Serializable