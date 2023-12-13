package com.fastcampus.payment.user.domain

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User private constructor(
    id: String,
    name: String,
) {

    @Id
    @Column(name = "user_id")
    var id: String = id
        protected set

    @Column(name = "name")
    var name: String = name
        protected set

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    var balance: UserBalance? = null
        protected set

    fun chargeBalance(balance: Long) {
        this.balance!!.charge(balance)
    }

    fun payBalance(amount: Long) {
        balance!!.pay(amount)
    }

    companion object {
        fun create(id: String, name: String, userBalanceId: String): User {
            val user = User(id, name)
            user.balance = UserBalance.create(userBalanceId, user)
            return user
        }
    }
}
