package com.example.wbsfinancialbackend.api.cryptocurrency.dtos

import com.example.wbsfinancialbackend.enums.FiatCurrency
import com.example.wbsfinancialbackend.enums.TimeInterval
import com.example.wbsfinancialbackend.utils.validation.customannotations.enums.ValueOfEnum

class CryptocurrenciesRequest(
    @field:ValueOfEnum(enumClass = FiatCurrency::class, byName = false) val vsCurrency: String,
    @field:ValueOfEnum(
        enumClass = TimeInterval::class,
        byName = false
    ) val priceChangePercentage: List<String>
)