package com.fastcampus.payment.payment.presentation

import com.fastcampus.payment.payment.domain.Payment

class PaymentMapper

fun Payment.toResponse(): PaymentResponse {
    return PaymentResponse(
        status = status.toString(),
    )
}

