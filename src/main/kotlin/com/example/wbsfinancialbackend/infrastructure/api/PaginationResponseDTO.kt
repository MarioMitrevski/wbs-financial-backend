package com.example.wbsfinancialbackend.infrastructure.api

data class PaginationResponseDTO(
    val page: Int?,
    val total: Long,
    val totalPages: Int,
    val hasNext: Boolean,
    val hasPrevious: Boolean
)
