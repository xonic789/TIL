package com.fastcampus.payment.paymentrequest.application

import com.fastcampus.payment.paymentrequest.domain.PaymentRequest
import com.fastcampus.payment.paymentrequest.presentation.PaymentRequestResponse

class PaymentMapper

fun PaymentRequest.toResponse(merchantName: String) = PaymentRequestResponse(
    requestId = this.id,
    merchantName = merchantName,
    amount = this.amount.value,
    tax = this.amount.tax,
)
