package com.example.wbsfinancialbackend.core.utils

fun isWholeNumber(num: Double): Boolean {
    return num.compareTo(num.toInt()) == 0
}