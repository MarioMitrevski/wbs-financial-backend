package com.example.wbsfinancialbackend.constants.endpoints

class WBSFinancialEndpoints {
    companion object {
        const val CRYPTOCURRENCY_ENDPOINT = "/cryptocurrency"
        const val CRYPTOCURRENCY_EXCHANGES_ENDPOINT = "$CRYPTOCURRENCY_ENDPOINT/exchanges"
        const val COMPANY_ENDPOINT = "/companies"
        const val NEWS_ENDPOINT = "/news"
    }
}