package com.example.wbsfinancialbackend.infrastructure.datasources.cryptocurrency

import java.io.Serializable
import java.math.BigDecimal
import java.util.*

data class CryptocurrencyDetailsResponseDTO(
    val symbol: String,
    val name: String,
    val image: CryptocurrencyImageDTO,
    val market_cap_rank: String,
    val hashing_algorithm: String?,
    val description: CryptocurrencyDescriptionDTO,
    val links: CryptocurrencyLinksDTO,
    val market_data: CryptocurrencyMarketDataDTO,
)

data class CryptocurrencyImageDTO(
    val small: String,
    val thumb: String,
    val large: String
)

data class CryptocurrencyDescriptionDTO(
    val en: String
)

data class CryptocurrencyLinksDTO(
    val homepage: List<String>,
    val blockchain_site: List<String>,
    val official_forum_url: List<String>,
    val twitter_screen_name: String?,
    val facebook_username: String?,
    val repos_url: CryptocurrencyReposDTO,
    val chat_url: List<String>,
    val subreddit_url: String?
)

data class CryptocurrencyReposDTO(
    val github: List<String>,
    val bitbucket: List<String>
)

data class CryptocurrencyMarketDataDTO(
    val total_supply: Long,
    val max_supply: Long,
    val circulating_supply: Long,
    val market_cap: FiatsDTO,
    val market_cap_change_24h_in_currency: FiatsDTO,
    val market_cap_change_percentage_24h_in_currency: FiatsDTO,
    val fully_diluted_valuation: FiatsDTO,
    val total_volume: FiatsDTO,
    val current_price: FiatsDTO,
    val ath: FiatsDTO,
    val ath_date: FiatDateDTO,
    val high_24h: FiatsDTO,
    val low_24h: FiatsDTO,
    val price_change_24h_in_currency: FiatsDTO,
    val price_change_percentage_24h_in_currency: FiatsDTO
): Serializable

data class FiatsDTO(
    val eur: BigDecimal?,
    val gbp: BigDecimal?,
    val usd: BigDecimal?
): Serializable

data class FiatDateDTO(
    val eur: Date?,
    val gbp: Date?,
    val usd: Date?
): Serializable