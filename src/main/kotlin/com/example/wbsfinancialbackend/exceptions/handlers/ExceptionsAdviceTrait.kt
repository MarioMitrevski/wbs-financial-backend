package com.example.wbsfinancialbackend.exceptions.handlers

import com.example.wbsfinancialbackend.exceptions.NotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.NativeWebRequest
import org.zalando.problem.Problem
import org.zalando.problem.Status
import org.zalando.problem.spring.web.advice.AdviceTrait

class ExceptionsAdviceTrait : AdviceTrait {

    @ExceptionHandler
    fun handleNotFoundException(
        exception: NotFoundException,
        request: NativeWebRequest
    ): ResponseEntity<Problem> = create(Status.NOT_FOUND, exception, request)

}