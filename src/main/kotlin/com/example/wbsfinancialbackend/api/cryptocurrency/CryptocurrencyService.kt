package com.example.wbsfinancialbackend.api.cryptocurrency

import java.util.concurrent.CompletableFuture

interface CryptocurrencyService {

    fun getCryptocurrencyDetails(name: String): CompletableFuture<String>
}