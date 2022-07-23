package com.example.wbsfinancialbackend.datasources.company.dtos

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class MarketTopStocksDTO(
    @JsonIgnore val serialVersionUID: Long = 7057218931959901316,
    @JsonProperty("companyName") val companyName: String,
    @JsonProperty("primaryExchange") val primaryExchange: String,
    @JsonProperty("symbol") val symbol: String,
    @JsonProperty("changePercent") val changePercent: Float,
    @JsonProperty("logo") val logo: String?
): Serializable