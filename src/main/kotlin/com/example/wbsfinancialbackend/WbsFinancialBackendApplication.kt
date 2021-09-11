package com.example.wbsfinancialbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class WbsFinancialBackendApplication

fun main(args: Array<String>) {
    runApplication<WbsFinancialBackendApplication>(*args)
}
