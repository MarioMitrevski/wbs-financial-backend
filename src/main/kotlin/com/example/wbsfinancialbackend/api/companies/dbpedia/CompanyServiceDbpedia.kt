package com.example.wbsfinancialbackend.api.companies.dbpedia

import com.example.wbsfinancialbackend.api.companies.CompanyService
import com.example.wbsfinancialbackend.config.RedisConfig.Companion.COMPANY_WIKI_LINKS_CACHE
import com.example.wbsfinancialbackend.constants.endpoints.SparqlEndpoints.Companion.DbpediaOntologyUrl
import com.example.wbsfinancialbackend.constants.endpoints.SparqlEndpoints.Companion.DbpediaResourceUrl
import com.example.wbsfinancialbackend.constants.endpoints.SparqlEndpoints.Companion.WikipediaResourceUrl
import com.example.wbsfinancialbackend.db.Predicate
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.rdf.model.impl.PropertyImpl
import org.apache.jena.riot.RDFParser
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class CompanyServiceDbpedia : CompanyService {

    companion object {
        private val supportedPredicates = mapOf(
            Pair("product", Predicate(DbpediaOntologyUrl.plus("product"), true)),
            Pair("service", Predicate(DbpediaOntologyUrl.plus("service"), true)),
            Pair("developer", Predicate(DbpediaOntologyUrl.plus("developer"), false)),
            Pair("designer", Predicate(DbpediaOntologyUrl.plus("designer"), false))
        )
        private val LOG = LoggerFactory.getLogger(CompanyServiceDbpedia::class.java)
    }

    @Cacheable(value = [COMPANY_WIKI_LINKS_CACHE], key = "#companyName + #predicate")
    override fun getCompanyWikiLinks(
        companyName: String,
        predicate: String
    ): List<String> {
        LOG.info("$companyName $predicate fetching from DBpedia")

        if (!supportedPredicates.containsKey(predicate)) {
            throw IllegalArgumentException("Predicate not supported!")
        }

        val modelCompany = ModelFactory.createDefaultModel()
        val url = DbpediaResourceUrl.plus(companyName)
        val future = CompletableFuture.runAsync {
            LOG.info("$companyName $predicate fetching...")
            RDFParser.source(url).acceptHeader("text/turtle").parse(modelCompany.graph)
        }.handle { _, _ ->
            LOG.info("$companyName $predicate fetching ended")

            val supportedPredicate = supportedPredicates.getValue(predicate)
            if (supportedPredicate.isSubject) {
                modelCompany.listObjectsOfProperty(PropertyImpl(supportedPredicate.fullUrl))
                    .mapWith { mapDbpediaResourceToWikiPage(it.toString()) }
                    .toList()
            } else {
                val stmtIterator =
                    modelCompany.listSubjectsWithProperty(PropertyImpl(supportedPredicate.fullUrl))
                stmtIterator.mapWith { mapDbpediaResourceToWikiPage(it.toString()) }.toList()
            }
        }
        return future.get()
    }

    private fun mapDbpediaResourceToWikiPage(dbpediaResource: String): String =
        WikipediaResourceUrl.plus(dbpediaResource.split("/").last())
}