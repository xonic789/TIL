package com.fastcampus.payment.user.domain.exception

class UserException {
    class NotEnoughBalanceException : RuntimeException("잔액이 부족합니다.")
}
