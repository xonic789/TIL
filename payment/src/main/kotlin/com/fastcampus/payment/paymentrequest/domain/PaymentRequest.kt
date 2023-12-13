package com.fastcampus.payment.paymentrequest.domain

import com.fastcampus.payment.domain.Amount
import com.fastcampus.payment.paymentrequest.domain.exception.PaymentRequestException
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "payment_requests")
class PaymentRequest private constructor(
    id: String,
    merchantId: String,
    amount: Amount,
    status: Status = Status.PENDING,
    failedAt: ZonedDateTime? = null,
    successAt: ZonedDateTime? = null,
    createdAt: ZonedDateTime,
    updatedAt: ZonedDateTime,
) {
    enum class Status {
        PENDING,
        SUCCESS,
        FAILED,
    }

    @Id
    @Column(name = "payment_request_id")
    var id: String = id
        protected set

    @Version
    var version: Int = 0
        protected set

    @Column(name = "merchant_id")
    var merchantId: String = merchantId
        protected set

    @Embedded
    @AttributeOverrides(
        value = [
            AttributeOverride(name = "value", column = Column(name = "amount_value")),
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

    @Column(name = "failed_at")
    var failedAt: ZonedDateTime? = failedAt
        protected set

    fun fail() {
        if (this.status != Status.PENDING) throw PaymentRequestException.AlreadyCompletedException()
        this.status = Status.FAILED
        this.failedAt = ZonedDateTime.now()
    }

    fun success() {
        if (this.status != Status.PENDING) throw PaymentRequestException.AlreadyCompletedException()
        this.status = Status.SUCCESS
        this.successAt = ZonedDateTime.now()
    }

    fun amount(): Long {
        return this.amount.amount()
    }

    companion object {
        internal fun create(
            id: String,
            amount: Long,
            merchantId: String,
        ): PaymentRequest {
            return PaymentRequest(
                id = id,
                merchantId = merchantId,
                amount = Amount.of(amount),
                status = Status.PENDING,
                createdAt = ZonedDateTime.now(),
                updatedAt = ZonedDateTime.now()
            )
        }
    }
}

