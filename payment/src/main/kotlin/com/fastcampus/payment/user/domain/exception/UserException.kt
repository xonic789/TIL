package com.fastcampus.payment.user.domain.exception

import com.fastcampus.payment.exception.DomainException

class UserException {

    companion object {
        private const val PREFIX: String = "USRD"
    }

    class NotEnoughBalanceException : DomainException(
        code = "${PREFIX}00001",
        messageCode = "잔액이 부족합니다",
    )
}
