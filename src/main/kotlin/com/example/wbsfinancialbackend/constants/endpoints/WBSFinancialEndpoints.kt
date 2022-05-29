package com.example.wbsfinancialbackend.constants.endpoints

class WBSFinancialEndpoints {
    companion object {
        const val CRYPTOCURRENCY_ENDPOINT = "/cryptocurrency"
        const val CRYPTOCURRENCY_EXCHANGES_ENDPOINT = "$CRYPTOCURRENCY_ENDPOINT/exchanges"
        const val COMPANY_ENDPOINT = "/companies"
        const val MARKET_ENDPOINT = "/market"

        const val STOCK_EXCHANGES_ENDPOINT = "$COMPANY_ENDPOINT/exchanges"
        const val NEWS_ENDPOINT = "/news"
    }
}