package com.fastcampus.payment.merchant.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "merchants")
class Merchant(
    id: String,
    name: String,
) {
    @Id
    @Column(name = "merchant_id")
    var id: String = id
        protected set

    @Column(name = "name")
    var name: String = name
        protected set

    companion object {
        fun create(id: String, name: String): Merchant {
            return Merchant(id, name)
        }
    }
}
