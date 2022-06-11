package com.example.wbsfinancialbackend.utils

fun isWholeNumber(num: Double): Boolean {
    return num.compareTo(num.toInt()) == 0
}