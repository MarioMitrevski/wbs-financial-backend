package com.example.wbsfinancialbackend.infrastructure.api.cryptocurrency.dtos

import com.example.wbsfinancialbackend.core.enums.FiatCurrency
import com.example.wbsfinancialbackend.core.enums.TimeInterval
import com.example.wbsfinancialbackend.core.utils.validation.customannotations.enums.ValueOfEnum

class CryptocurrenciesRequest(
    @field:ValueOfEnum(enumClass = FiatCurrency::class, byName = false) val vsCurrency: String,
    @field:ValueOfEnum(
        enumClass = TimeInterval::class,
        byName = false
    ) val priceChangePercentage: List<String>
)