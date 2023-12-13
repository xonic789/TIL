package com.fastcampus.payment.exception

import org.springframework.http.HttpStatus

open class ApiException(
    val status: HttpStatus,
    val code: String,
    val messageCode: String,
) : RuntimeException(messageCode)

open class InternalServerException(code: String, messageCode: String) :
    ApiException(HttpStatus.INTERNAL_SERVER_ERROR, code, messageCode)

open class NoLongerAvailableException(code: String, messageCode: String) :
    ApiException(HttpStatus.GONE, code, messageCode)

open class BadRequestException(code: String, messageCode: String) :
    ApiException(HttpStatus.BAD_REQUEST, code, messageCode)

open class EntityNotFoundException(code: String, messageCode: String) :
    ApiException(HttpStatus.NOT_FOUND, code, messageCode)

open class UnauthorizedException(code: String, messageCode: String) :
    ApiException(HttpStatus.UNAUTHORIZED, code, messageCode)

open class EntityExistException(code: String, messageCode: String) :
    ApiException(HttpStatus.CONFLICT, code, messageCode)
