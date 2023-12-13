package com.fastcampus.payment.config

import com.fastcampus.payment.exception.ApiException
import com.fastcampus.payment.exception.DomainException
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

data class ErrorResponse(val code: String, val reason: String)

@RestControllerAdvice
class ExceptionControllerAdvice : ResponseEntityExceptionHandler() {
    @ExceptionHandler(ApiException::class)
    fun handleApiException(ex: ApiException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(ex.status)
            .contentType(MediaType.APPLICATION_JSON)
            .body(ErrorResponse(ex.code, ex.message ?: ""))
    }


    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<ErrorResponse> {
        ex.printStackTrace()
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse("INTERNAL_SERVER", "일시적인 서버 장애입니다."))
    }

    @ExceptionHandler(DomainException::class)
    fun handleDomainException(ex: DomainException): ResponseEntity<ErrorResponse> {
        ex.printStackTrace()
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse(ex.code, ex.messageCode))
    }
}

