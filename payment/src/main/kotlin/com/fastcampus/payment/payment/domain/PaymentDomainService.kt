package com.fastcampus.payment.payment.domain

import com.fastcampus.payment.payment.domain.exception.PaymentException
import com.fastcampus.payment.paymentrequest.domain.PaymentRequest
import com.fastcampus.payment.user.domain.User

class PaymentDomainService {

    fun payment(
        user: User,
        paymentRequest: PaymentRequest,
        payment: Payment,
    ) {
        val requestAmount = paymentRequest.amount()
        val amount = payment.amount()
        if (requestAmount != amount) {
            payment.fail(user.id)
            paymentRequest.fail()
            throw PaymentException.InvalidAmountException()
        }

        try {
            user.payBalance(amount)
        } catch (e: Exception) {
            payment.fail(user.id)
            paymentRequest.fail()
            throw e
        }
        payment.success(user.id)
        paymentRequest.success()
    }
}
