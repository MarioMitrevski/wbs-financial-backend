package com.example.wbsfinancialbackend.config


import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
            .allowedOrigins("http://localhost:3000")
            .allowedHeaders("*")
            .exposedHeaders(
                "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Allow",
                "Content-Disposition", "Strict-Transport-Security"
            )
    }
}
