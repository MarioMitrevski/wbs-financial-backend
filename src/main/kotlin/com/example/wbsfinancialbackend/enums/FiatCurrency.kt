package com.example.wbsfinancialbackend.enums

enum class FiatCurrency(override val value: String): BaseEnum {
    EUR("eur"),
    USD("usd"),
    GBP("gbp")
}