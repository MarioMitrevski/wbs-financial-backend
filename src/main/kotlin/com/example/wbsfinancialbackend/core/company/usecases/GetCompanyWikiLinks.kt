package com.example.wbsfinancialbackend.core.company.usecases

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyWikiLinksGateway
import com.example.wbsfinancialbackend.infrastructure.config.RedisConfig
import com.example.wbsfinancialbackend.infrastructure.datasources.UseCase
import org.springframework.cache.annotation.Cacheable

@UseCase
class GetCompanyWikiLinks(
    val getCompanyWikiLinksGateway: GetCompanyWikiLinksGateway
) {
    @Cacheable(value = [RedisConfig.COMPANY_WIKI_LINKS_CACHE_VALUE], key = RedisConfig.COMPANY_WIKI_LINKS_CACHE_KEY)
    operator fun invoke(
        companyName: String,
        predicate: String
    ): List<String> {
        return getCompanyWikiLinksGateway.getCompanyWikiLinks(companyName, predicate)
    }
}