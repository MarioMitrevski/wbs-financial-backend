package com.example.wbsfinancialbackend.infrastructure.exceptions.handlers

import com.example.wbsfinancialbackend.infrastructure.exceptions.NotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.NativeWebRequest
import org.zalando.problem.Problem
import org.zalando.problem.Status
import org.zalando.problem.spring.web.advice.AdviceTrait

@ControllerAdvice
class ExceptionsAdviceTrait : AdviceTrait {

    @ExceptionHandler
    fun handleNotFoundException(
        exception: NotFoundException,
        request: NativeWebRequest
    ): ResponseEntity<Problem> = create(Status.NOT_FOUND, exception, request)

}