package com.example.wbsfinancialbackend

import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.DotenvEntry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.core.env.MapPropertySource
import org.springframework.core.env.MutablePropertySources
import org.springframework.core.env.StandardEnvironment
import org.springframework.scheduling.annotation.EnableAsync
import java.util.stream.Collectors


@SpringBootApplication
@EnableAsync
@EnableCaching
@EnableFeignClients
@ConfigurationPropertiesScan
class WbsFinancialBackendApplication

fun main(args: Array<String>) {

    val env: Map<String, Any> = Dotenv.load()
        .entries()
        .stream()
        .collect(
            Collectors.toMap(DotenvEntry::getKey, DotenvEntry::getValue)
        )
    SpringApplicationBuilder(WbsFinancialBackendApplication::class.java)
        .environment(object : StandardEnvironment() {
            override fun customizePropertySources(propertySources: MutablePropertySources) {
                super.customizePropertySources(propertySources)
                propertySources.addLast(MapPropertySource("dotenvProperties", env))
            }
        }).run(*args)

}
