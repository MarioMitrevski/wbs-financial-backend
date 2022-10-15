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
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(48))
                )
                .withCacheConfiguration(
                    NEWS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5))
                )
                .withCacheConfiguration(
                    MARKET_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(30))
                )
                .withCacheConfiguration(
                    COMPANY_SECTORS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(24))
                )
                .withCacheConfiguration(
                    COMPANY_EARNINGS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(24))
                )
                .withCacheConfiguration(
                    COMPANY_ANNUAL_REPORTS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(24))
                )
                .withCacheConfiguration(
                    COMPANY_DETAILS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(1))
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
    }
}

