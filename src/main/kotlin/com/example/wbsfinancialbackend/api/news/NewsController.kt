package com.example.wbsfinancialbackend.api.news

import com.example.wbsfinancialbackend.constants.endpoints.WBSFinancialEndpoints
import com.example.wbsfinancialbackend.datasources.news.NewsResponseDTO
import com.example.wbsfinancialbackend.domain.news.usecases.GetNews
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = [WBSFinancialEndpoints.NEWS_ENDPOINT])
class NewsController(
    val getNews: GetNews
) {

    @GetMapping
    fun getNews(@RequestParam("category") category: String): ResponseEntity<List<NewsResponseDTO>> {
        return ResponseEntity.ok(getNews.invoke(category))
    }
}