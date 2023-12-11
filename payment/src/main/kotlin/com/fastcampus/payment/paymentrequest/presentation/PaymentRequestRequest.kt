package com.fastcampus.payment.paymentrequest.presentation

data class PaymentRequestRequest(
    val amount: Long,
    val merchantId: String,
)
