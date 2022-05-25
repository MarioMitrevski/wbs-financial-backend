package com.example.wbsfinancialbackend.api.cryptocurrency

import java.util.concurrent.CompletableFuture

interface CryptocurrencyService {

    fun getCryptocurrencyDescription(name: String): CompletableFuture<String>
}