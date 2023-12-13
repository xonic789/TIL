package com.fastcampus.payment.payment.domain

import com.fastcampus.payment.domain.Amount
import com.fastcampus.payment.payment.domain.exception.PaymentException
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
    // 결제 가능 만료시간
    expiredAt: ZonedDateTime,
    readyAt: ZonedDateTime? = null,
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

    @Column(name = "expired_at")
    var expiredAt: ZonedDateTime = expiredAt
        protected set

    @Version
    var version: Int = 0
        protected set

    fun success(userId: String) {
        if (isExpired()) {
            throw PaymentException.ExpiredException()
        }
        if (isCompleted()) {
            throw PaymentException.AlreadyCompletedException()
        }
        this.status = Status.SUCCESS
        this.successAt = ZonedDateTime.now()
        this.updatedAt = ZonedDateTime.now()
        this.userId = userId
    }

    fun fail(userId: String) {
        this.status = Status.FAILED
        this.failedAt = ZonedDateTime.now()
        this.updatedAt = ZonedDateTime.now()
        this.userId = userId
    }

    fun amount(): Long {
        return this.amount.amount()
    }

    private fun isFailed(): Boolean {
        return this.status == Status.FAILED && this.failedAt != null
    }

    fun isCompleted(): Boolean {
        return this.status == Status.SUCCESS || this.status == Status.FAILED
    }

    fun isExpired(): Boolean {
        return this.status == Status.READY && this.expiredAt < ZonedDateTime.now()
    }

    companion object {
        fun ready(
            id: String,
            merchantId: String,
            amount: Amount,
            paymentRequestId: String,
        ): Payment {
            val now = ZonedDateTime.now()
            return Payment(
                id = id,
                merchantId = merchantId,
                amount = amount,
                paymentRequestId = paymentRequestId,
                status = Status.READY,
                createdAt = now,
                updatedAt = now,
                readyAt = now,
                expiredAt = now.plusMinutes(10),
            )
        }
    }

    enum class Status {
        READY,
        SUCCESS,
        CANCELLED,
        FAILED,
    }
}
