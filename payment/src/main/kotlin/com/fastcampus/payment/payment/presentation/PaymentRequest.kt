package com.fastcampus.payment.payment.presentation

data class PaymentRequest(
    val merchantId: String,
    val requestId: String,
    val userId: String,
    val amount: Long,
)

