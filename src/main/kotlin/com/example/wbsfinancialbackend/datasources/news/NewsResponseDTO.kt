package com.example.wbsfinancialbackend.datasources.news

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class NewsResponseDTO(
    @JsonIgnore val serialVersionUID: Long = 3028562422947890539,
    @JsonProperty("id") val id: Int,
    @JsonProperty("source") val source: String,
    @JsonProperty("headline") val headline: String,
    @JsonProperty("summary") val summary: String,
    @JsonProperty("url") val url: String,
    @JsonProperty("image") val image: String,
    @JsonProperty("datetime") val datetime: Long,
    @JsonProperty("category") val category: String
) : Serializable