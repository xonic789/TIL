package com.fastcampus.payment.payment.domain

import com.fastcampus.payment.interfaces.UUIDGenerator
import com.fastcampus.payment.paymentrequest.domain.PaymentRequest
import com.fastcampus.payment.user.domain.User
import com.fastcampus.payment.user.domain.exception.UserException

class PaymentDomainService {

    fun payment(user: User, paymentRequest: PaymentRequest, uuidGenerator: UUIDGenerator): Payment {
        if (paymentRequest.isCompleted()) {
            return Payment.fail(
                id = uuidGenerator.generate(),
                merchantId = paymentRequest.merchantId,
                amount = paymentRequest.amount,
                paymentRequestId = paymentRequest.id,
                userId = user.id,
            )
        }

        val amount = paymentRequest.amount
        try {
            user.payBalance(amount.amount())
        } catch (e: UserException.NotEnoughBalanceException) {
            paymentRequest.fail()
            return Payment.fail(
                id = uuidGenerator.generate(),
                merchantId = paymentRequest.merchantId,
                amount = amount,
                paymentRequestId = paymentRequest.id,
                userId = user.id,
            )
        }
        paymentRequest.success()
        return Payment.success(
            id = uuidGenerator.generate(),
            merchantId = paymentRequest.merchantId,
            amount = amount,
            paymentRequestId = paymentRequest.id,
            userId = user.id,
        )
    }
}
