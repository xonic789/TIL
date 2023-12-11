package com.fastcampus.payment.paymentrequest.presentation

data class PaymentRequestResponse(
    val requestId: String,
    val merchantName: String,
    val amount: Long,
    val tax: Long,
)
