package com.example.wbsfinancialbackend.api.company.dbpedia

import com.example.wbsfinancialbackend.api.company.CompanyService
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.rdf.model.impl.PropertyImpl
import org.apache.jena.riot.RDFParser
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class CompanyServiceDbpedia : CompanyService {

    companion object {
        private const val DbpediaResourceUrl = "http://dbpedia.org/page/"
        private const val WikipediaResourceUrl = "https://en.wikipedia.org/wiki/"
        private const val DbpediaOntologyUrl = "http://dbpedia.org/ontology/"
    }

    @Async
    override fun getCompanyWikiLinks(
        companyName: String,
        predicate: String,
        isSubject: Boolean
    ): CompletableFuture<List<String>> {
        val modelCompany = ModelFactory.createDefaultModel()
        val url = DbpediaResourceUrl.plus(companyName)
        return CompletableFuture.runAsync {
            RDFParser.source(url).httpAccept("text/turtle").parse(modelCompany.graph)
        }.handle { void, throwable ->
            if (isSubject) {
                modelCompany.listObjectsOfProperty(PropertyImpl(DbpediaOntologyUrl.plus(predicate)))
                    .mapWith { mapDbpediaResourceToWikiPage(it.toString()) }
                    .toList()
            } else {
                val stmtIterator = modelCompany.listSubjectsWithProperty(PropertyImpl(DbpediaOntologyUrl.plus(predicate)))
                stmtIterator.mapWith { mapDbpediaResourceToWikiPage(it.toString())}.toList()
            }
        }
    }

    private fun mapDbpediaResourceToWikiPage(dbpediaResource: String): String =
        WikipediaResourceUrl.plus(dbpediaResource.split("/").last())
}