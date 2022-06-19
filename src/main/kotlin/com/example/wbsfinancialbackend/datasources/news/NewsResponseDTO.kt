package com.example.wbsfinancialbackend.datasources.news

data class NewsResponseDTO(
    val id: Int,
    val source: String,
    val headline: String,
    val summary: String,
    val url: String,
    val image: String,
    val datetime: Long,
    val category: String
)