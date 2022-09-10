package com.example.wbsfinancialbackend.domain.news.usecases

import com.example.wbsfinancialbackend.config.RedisConfig.Companion.NEWS_CACHE_KEY
import com.example.wbsfinancialbackend.config.RedisConfig.Companion.NEWS_CACHE_VALUE
import com.example.wbsfinancialbackend.datasources.FinHubClient
import com.example.wbsfinancialbackend.datasources.UseCase
import com.example.wbsfinancialbackend.datasources.news.NewsResponseDTO
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetNews(
    val finHubClient: FinHubClient
) {

    @Cacheable(value = [NEWS_CACHE_VALUE], key = NEWS_CACHE_KEY)
    operator fun invoke(category: String): List<NewsResponseDTO> {
        return finHubClient.getNews(category)
    }
}