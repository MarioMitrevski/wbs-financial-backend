package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class CompanyOverviewResponseDTO(@JsonProperty("Description") val Description: String)