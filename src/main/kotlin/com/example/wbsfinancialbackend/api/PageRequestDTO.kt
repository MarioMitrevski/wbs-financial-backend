package com.example.wbsfinancialbackend.api

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Builder
import lombok.Data

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PageRequestDTO(
    val page: Int,
    val size: Int
)