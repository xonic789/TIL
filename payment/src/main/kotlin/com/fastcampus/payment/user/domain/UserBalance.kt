package com.fastcampus.payment.user.domain

import com.fastcampus.payment.user.domain.exception.UserException
import jakarta.persistence.*

@Entity
@Table(name = "user_balances")
class UserBalance private constructor(
    id: String,
    user: User,
    balance: Long,
) {

    @Id
    @Column(name = "user_balance_id")
    var id: String = id
        protected set

    @Version
    var version: Int = 0
        protected set

    fun charge(balance: Long) {
        this.balance += balance
    }

    fun pay(amount: Long) {
        if (this.balance < amount) {
            throw UserException.NotEnoughBalanceException()
        }
        this.balance -= amount
    }


    @Column(name = "balance")
    var balance: Long = balance
        protected set

    @OneToOne
    @JoinColumn(name = "user_id")
    var user: User = user
        protected set

    companion object {
        fun create(id: String, user: User): UserBalance {
            return UserBalance(id, user, 0)
        }
    }
}
