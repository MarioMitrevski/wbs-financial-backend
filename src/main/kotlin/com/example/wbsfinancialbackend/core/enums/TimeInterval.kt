package com.example.wbsfinancialbackend.core.enums

enum class TimeInterval(override val value: String): BaseEnum {
    HOUR("1h"),
    DAY("24h"),
    WEEK("7d")
}