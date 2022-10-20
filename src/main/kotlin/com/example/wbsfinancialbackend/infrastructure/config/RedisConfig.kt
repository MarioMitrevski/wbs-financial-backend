package com.example.wbsfinancialbackend.infrastructure.config

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import java.time.Duration

@EnableCaching
@Configuration
class RedisConfig {

    @Bean
    fun cacheConfiguration(): RedisCacheConfiguration {
        return RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofHours(2))
            .disableCachingNullValues()
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(
                    GenericJackson2JsonRedisSerializer()
                )
            )
    }

    @Bean
    fun redisCacheManagerBuilderCustomizer(): RedisCacheManagerBuilderCustomizer {
        return RedisCacheManagerBuilderCustomizer { builder: RedisCacheManager.RedisCacheManagerBuilder ->
            builder
                .withCacheConfiguration(
                    COMPANY_WIKI_LINKS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(COMPANY_WIKI_LINKS_CACHE_TTL))
                )
                .withCacheConfiguration(
                    NEWS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(NEWS_CACHE_TTL))
                )
                .withCacheConfiguration(
                    MARKET_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(MARKET_CACHE_TTL))
                )
                .withCacheConfiguration(
                    COMPANY_SECTORS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(COMPANY_SECTORS_CACHE_TTL))
                )
                .withCacheConfiguration(
                    COMPANY_EARNINGS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(COMPANY_EARNINGS_CACHE_TTL))
                )
                .withCacheConfiguration(
                    COMPANY_ANNUAL_REPORTS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(COMPANY_ANNUAL_REPORTS_CACHE_TTL))
                )
                .withCacheConfiguration(
                    COMPANY_DETAILS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(COMPANY_DETAILS_CACHE_TTL))
                )
                .withCacheConfiguration(
                    CRYPTO_MARKET_DATA_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(CRYPTO_MARKET_DATA_TTL))
                )
        }
    }

    companion object {
        const val COMPANY_WIKI_LINKS_CACHE_VALUE = "companyWikiLinks"
        const val COMPANY_WIKI_LINKS_CACHE_KEY = "#companyName + #predicate"
        const val COMPANY_SECTORS_CACHE_VALUE = "companySectors"
        const val COMPANY_EARNINGS_CACHE_VALUE = "companyEarnings"
        const val COMPANY_ANNUAL_REPORTS_CACHE_VALUE = "companyAnnualReports"
        const val COMPANY_DETAILS_CACHE_VALUE = "companyDetails"
        const val NEWS_CACHE_VALUE = "news"
        const val NEWS_CACHE_KEY = "#category"
        const val MARKET_CACHE_VALUE = "market"
        const val MARKET_TOP_STOCKS_CACHE_KEY = "#topStocks"
        const val CRYPTO_MARKET_DATA_VALUE = "cryptoMarketData"


        /**
         * Cache Time to live represented in seconds
        * */
        const val COMPANY_WIKI_LINKS_CACHE_TTL = 172800L
        const val COMPANY_SECTORS_CACHE_TTL = 86400L
        const val COMPANY_EARNINGS_CACHE_TTL = 86400L
        const val COMPANY_ANNUAL_REPORTS_CACHE_TTL = 86400L
        const val COMPANY_DETAILS_CACHE_TTL = 3600L
        const val NEWS_CACHE_TTL = 300L
        const val MARKET_CACHE_TTL = 1800L
        const val CRYPTO_MARKET_DATA_TTL = 3L

    }
}


