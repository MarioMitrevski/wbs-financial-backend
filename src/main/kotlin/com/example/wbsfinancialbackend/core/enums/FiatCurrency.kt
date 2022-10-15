package com.example.wbsfinancialbackend.core.enums

enum class FiatCurrency(override val value: String): BaseEnum {
    EUR("eur"),
    USD("usd"),
    GBP("gbp")
}