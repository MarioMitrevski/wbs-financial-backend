package com.example.wbsfinancialbackend.core.cryptocurrency.usecases

import com.example.wbsfinancialbackend.core.cryptocurrency.gateways.GetCryptocurrencyDetailsGateway
import com.example.wbsfinancialbackend.infrastructure.config.RedisConfig.Companion.CRYPTO_MARKET_DATA_VALUE
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency.CryptocurrencyMarketDataDTO
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetCryptocurrencyMarketData(
    val getCryptocurrencyDetailsGateway: GetCryptocurrencyDetailsGateway
) {

    @Cacheable(value = [CRYPTO_MARKET_DATA_VALUE])
    operator fun invoke(id: String): CryptocurrencyMarketDataDTO {
        return getCryptocurrencyDetailsGateway.getCryptocurrencyMarketData(id)
    }
}