package com.example.wbsfinancialbackend.config

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import java.time.Duration

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
                    COMPANY_WIKI_LINKS_CACHE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofHours(2))
                )
                .withCacheConfiguration(
                    NEWS_CACHE_VALUE,
                    RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5))
                )
        }
    }

    companion object {
        const val COMPANY_WIKI_LINKS_CACHE = "companyWikiLinks"
        const val NEWS_CACHE_VALUE = "news"
        const val NEWS_CACHE_KEY = "#category"
    }
}


