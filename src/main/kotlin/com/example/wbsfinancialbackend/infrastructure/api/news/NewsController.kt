package com.example.wbsfinancialbackend.infrastructure.api.news

import com.example.wbsfinancialbackend.core.enums.NewsCategory
import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.core.news.usecases.GetNews
import com.example.wbsfinancialbackend.core.utils.validation.customannotations.enums.ValueOfEnum
import com.example.wbsfinancialbackend.infrastructure.datasources.news.NewsResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.NEWS_ENDPOINT])
class NewsController(
    val getNews: GetNews
) {

    @GetMapping
    fun getNews(
        @Valid @ValueOfEnum(
            enumClass = NewsCategory::class,
            byName = false
        ) @RequestParam("category") category: String
    ): ResponseEntity<List<NewsResponseDTO>> {
        return ResponseEntity.ok(getNews.invoke(category))
    }
}