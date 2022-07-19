package com.example.wbsfinancialbackend.datasources

import org.springframework.stereotype.Component

@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class UseCase(val value: String = "")
