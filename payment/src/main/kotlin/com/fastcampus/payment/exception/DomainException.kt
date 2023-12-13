package com.fastcampus.payment.exception

open class DomainException(
    val code: String,
    val messageCode: String,
) : RuntimeException(messageCode)

