package com.example.wbsfinancialbackend.core.news.usecases

import com.example.wbsfinancialbackend.core.news.gateways.GetNewsGateway
import com.example.wbsfinancialbackend.infrastructure.config.RedisConfig.Companion.NEWS_CACHE_KEY
import com.example.wbsfinancialbackend.infrastructure.config.RedisConfig.Companion.NEWS_CACHE_VALUE
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import com.example.wbsfinancialbackend.infrastructure.datasources.news.NewsResponseDTO
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetNews(
    val getNewsGateway: GetNewsGateway
) {

    @Cacheable(value = [NEWS_CACHE_VALUE], key = NEWS_CACHE_KEY)
    operator fun invoke(category: String): List<NewsResponseDTO> {
        return getNewsGateway.getNews(category)
    }
}