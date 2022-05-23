package com.example.wbsfinancialbackend.datasources.news

import com.fasterxml.jackson.annotation.JsonProperty

data class NewsResponseDTO(
    @get:JsonProperty("id") val id: Int,
    @get:JsonProperty("source") val source: String,
    @get:JsonProperty("headline") val headline: String,
    @get:JsonProperty("summary") val summary: String,
    @get:JsonProperty("url") val url: String,
    @get:JsonProperty("image") val image: String,
    @get:JsonProperty("datetime") val datetime: Long,
)