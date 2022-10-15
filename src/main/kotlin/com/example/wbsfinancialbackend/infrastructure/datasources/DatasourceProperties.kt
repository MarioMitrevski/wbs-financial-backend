package com.example.wbsfinancialbackend.infrastructure.datasources

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "datasource-keys")
@ConstructorBinding
data class DatasourceProperties(
    val iexKey: String,
    val marketstackKey: String,
    val finhubKey: String,
    val alphavantageKey: String
)