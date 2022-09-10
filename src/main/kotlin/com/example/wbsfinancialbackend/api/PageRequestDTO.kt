package com.example.wbsfinancialbackend.api

import org.jetbrains.annotations.NotNull
import javax.validation.Valid
import javax.validation.constraints.Min

data class PageRequestDTO<T>(
    @field:NotNull @field:Min(0) val page: Int,
    @field:NotNull @field:Min(1) val size: Int,
    @field:Valid val filterBy: T
)