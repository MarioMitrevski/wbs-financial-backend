package com.example.wbsfinancialbackend.api.cryptocurrency.dbpedia

import com.example.wbsfinancialbackend.api.cryptocurrency.CryptocurrencyService
import org.apache.jena.query.Query
import org.apache.jena.query.QueryExecutionFactory
import org.apache.jena.query.QueryFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class CryptocurrencyServiceDbpedia : CryptocurrencyService {

    @Async
    override fun getCryptocurrencyDetails(name: String): CompletableFuture<String> {
        val queryString =
            """prefix dbo: <http://dbpedia.org/ontology/> prefix dbr: <http://dbpedia.org/resource/> SELECT ?abstract WHERE { dbr:${name} dbo:abstract ?abstract FILTER (lang(?abstract) = "en") }"""

        val query: Query = QueryFactory.create(queryString)
        try {
            val qexec = QueryExecutionFactory.sparqlService(SPARQL_ENDPOINT, query)
            val results = qexec.execSelect()
            return CompletableFuture.completedFuture(results.nextSolution().get("abstract").toString())
        } catch (exception: Exception) {
            throw Exception()
        }
    }

    companion object {
        private const val SPARQL_ENDPOINT = "http://dbpedia.org/sparql"
    }
}