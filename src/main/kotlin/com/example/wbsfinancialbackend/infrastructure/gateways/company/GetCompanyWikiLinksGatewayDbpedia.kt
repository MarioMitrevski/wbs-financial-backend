package com.example.wbsfinancialbackend.infrastructure.gateways.company

import com.example.wbsfinancialbackend.core.company.gateways.GetCompanyWikiLinksGateway
import com.example.wbsfinancialbackend.core.company.Predicate
import com.example.wbsfinancialbackend.infrastructure.constants.endpoints.SparqlEndpoints
import com.example.wbsfinancialbackend.infrastructure.exceptions.NotSupportedException
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.rdf.model.impl.PropertyImpl
import org.apache.jena.riot.RDFParser
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture

@Service
class GetCompanyWikiLinksGatewayDbpedia : GetCompanyWikiLinksGateway {

    override fun getCompanyWikiLinks(companyName: String, predicate: String): List<String> {
        LOG.info("$companyName $predicate fetching from DBpedia")

        if (!supportedPredicates.containsKey(predicate)) {
            throw NotSupportedException("Predicate $predicate not supported!")
        }

        val modelCompany = ModelFactory.createDefaultModel()
        val formattedCompanyName = formatCompanyName(companyName)
        val url = SparqlEndpoints.DbpediaResourceUrl.plus(formattedCompanyName)
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
        SparqlEndpoints.WikipediaResourceUrl.plus(dbpediaResource.split("/").last())

    private fun formatCompanyName(companyName: String): String =
        if (companyName.last() == '.') companyName.dropLast(1) else companyName

    companion object {
        private val supportedPredicates = mapOf(
            Pair("product", Predicate(SparqlEndpoints.DbpediaOntologyUrl.plus("product"), true)),
            Pair("service", Predicate(SparqlEndpoints.DbpediaOntologyUrl.plus("service"), true)),
            Pair("developer", Predicate(SparqlEndpoints.DbpediaOntologyUrl.plus("developer"), false)),
            Pair("designer", Predicate(SparqlEndpoints.DbpediaOntologyUrl.plus("designer"), false))
        )
        private val LOG = LoggerFactory.getLogger(GetCompanyWikiLinksGatewayDbpedia::class.java)
    }
}