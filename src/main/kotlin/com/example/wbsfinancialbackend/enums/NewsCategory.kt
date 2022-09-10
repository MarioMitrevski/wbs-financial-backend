package com.example.wbsfinancialbackend.enums

enum class NewsCategory(override val value: String): BaseEnum {
    COMPANY("general"),
    CRYPTOCURRENCY("crypto")
}