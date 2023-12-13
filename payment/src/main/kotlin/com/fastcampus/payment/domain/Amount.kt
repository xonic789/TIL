package com.fastcampus.payment.domain

import jakarta.persistence.Embeddable

@Embeddable
class Amount private constructor(
    value: Long,
) {
    fun amount(): Long {
        return value
    }

    var value: Long = value
        protected set

    companion object {
        fun of(value: Long): Amount {
            if (value < 0) throw IllegalArgumentException("금액은 0원 이상이어야 합니다.")
            return Amount(value)
        }
    }
}
