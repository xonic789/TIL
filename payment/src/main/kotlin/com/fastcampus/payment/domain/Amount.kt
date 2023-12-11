package com.fastcampus.payment.domain

import jakarta.persistence.Embeddable

@Embeddable
class Amount private constructor(
    value: Long,
    tax: Long,
) {
    fun amount(): Long {
        return value + tax
    }

    var value: Long = value
        protected set

    var tax: Long = tax
        protected set

    companion object {
        fun of(value: Long): Amount {
            val tax = calculateTax(value)
            return Amount(value - tax, tax)
        }

        private fun calculateTax(value: Long): Long {
            // 10% tax, round up
            return (value * 0.1).toLong()
        }
    }
}
