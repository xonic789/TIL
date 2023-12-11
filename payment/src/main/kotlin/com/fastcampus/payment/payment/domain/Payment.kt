package com.fastcampus.payment.payment.domain

import com.fastcampus.payment.domain.Amount
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "payments")
class Payment private constructor(
    id: String,
    merchantId: String,
    userId: String? = null,
    paymentRequestId: String,
    amount: Amount,
    status: Status,
    createdAt: ZonedDateTime,
    updatedAt: ZonedDateTime,
    successAt: ZonedDateTime? = null,
    cancelledAt: ZonedDateTime? = null,
    failedAt: ZonedDateTime? = null,
) {

    @Id
    @Column(name = "payment_id")
    var id: String = id
        protected set

    @Column(name = "merchant_id")
    var merchantId: String = merchantId
        protected set

    @Column(name = "user_id")
    var userId: String? = userId
        protected set

    @Column(name = "payment_request_id")
    var paymentRequestId: String = paymentRequestId
        protected set

    @Embedded
    @AttributeOverrides(
        value = [
            AttributeOverride(name = "value", column = Column(name = "amount_value")),
            AttributeOverride(name = "tax", column = Column(name = "amount_tax")),
        ]
    )
    var amount: Amount = amount
        protected set

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status: Status = status
        protected set

    @Column(name = "created_at")
    var createdAt: ZonedDateTime = createdAt
        protected set

    @Column(name = "updated_at")
    var updatedAt: ZonedDateTime = updatedAt
        protected set

    @Column(name = "success_at")
    var successAt: ZonedDateTime? = successAt
        protected set

    @Column(name = "cancelled_at")
    var cancelledAt: ZonedDateTime? = cancelledAt
        protected set

    @Column(name = "failed_at")
    var failedAt: ZonedDateTime? = failedAt
        protected set

    companion object {
        fun success(
            id: String,
            merchantId: String,
            amount: Amount,
            paymentRequestId: String,
            userId: String
        ): Payment {
            return Payment(
                id = id,
                merchantId = merchantId,
                paymentRequestId = paymentRequestId,
                amount = amount,
                status = Status.SUCCESS,
                createdAt = ZonedDateTime.now(),
                updatedAt = ZonedDateTime.now(),
                successAt = ZonedDateTime.now(),
                userId = userId,
            )
        }

        fun fail(
            id: String,
            merchantId: String,
            amount: Amount,
            paymentRequestId: String,
            userId: String
        ): Payment {
            return Payment(
                id = id,
                merchantId = merchantId,
                paymentRequestId = paymentRequestId,
                amount = amount,
                status = Status.FAILED,
                createdAt = ZonedDateTime.now(),
                updatedAt = ZonedDateTime.now(),
                failedAt = ZonedDateTime.now(),
                userId = userId,
            )
        }
    }

    enum class Status {
        SUCCESS,
        CANCELLED,
        FAILED,
    }
}
