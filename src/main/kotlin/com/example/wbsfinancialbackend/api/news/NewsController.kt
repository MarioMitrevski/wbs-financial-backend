package com.example.wbsfinancialbackend.api.news

import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.datasources.news.NewsResponseDTO
import com.example.wbsfinancialbackend.domain.news.usecases.GetNews
import com.example.wbsfinancialbackend.enums.NewsCategory
import com.example.wbsfinancialbackend.utils.validation.customannotations.enums.ValueOfEnum
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